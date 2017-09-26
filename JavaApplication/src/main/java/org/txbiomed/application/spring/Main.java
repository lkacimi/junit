/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.spring;

import java.awt.Color;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.txbiomed.application.helper.StringHelperInterface;
import org.txbiomed.application.entities.*;
import org.txbiomed.application.kafka.KafkaConsumerImpl;
import org.txbiomed.application.kafka.KafkaProducerImpl;

/**
 *
 * @author lkacimi
 */
@ComponentScan(value = "org.txbiomed.application.spring")
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Main.class);
        ctx.refresh();
        ConversionService conversionService = ctx.getBean(ConversionService.class);
        System.out.println(conversionService.convert(6));
        System.out.println(StringHelperInterface.areFirstAndLastCharactersTheSame("ABA"));

        System.out.println(isPrime(2));

        //find double of first even number > 3 among a list
        List<Integer> values = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9);

        System.out.println(values.stream().filter(e -> e > 3).filter(e -> e % 2 == 0).map(e -> e * 2).findFirst().get());

        doThis(() -> "Hello World");
        System.out.println(
                values.stream()
                        .filter(e -> e % 2 == 0)
                        .filter(e -> e % 3 == 0)
                        .reduce(0, Integer::sum)
        );

        Runnable r = () -> System.out.println("Hello");

        TimeIt.run(r);

        System.out.println(IntStream.iterate(0, e -> e + 2).filter(e -> e > 10).limit(200).sum());

        Function<Integer, Integer> increment = e -> e + 1;
        Function<Integer, Integer> doubleIt = e -> e * 2;

        System.out.println(doWork(5, increment.andThen(doubleIt).andThen(doubleIt).andThen(increment)));

        printSnap(new Camera(Color::darker, Color::brighter)); // decorator design pattern using lambdas

        Mailer.send(mailer -> mailer.from().to().subject());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        Animal a = new Animal();
        a.setName("Joy");
        a.setSex(Sex.MALE);
        em.getTransaction().begin();
        em.persist(a);
        em.flush();
        em.getTransaction().commit();
        em.close();

        File[] files = FileClass.getFiles();

        Arrays.asList(files).parallelStream().filter(e -> e.getName().matches("^p.*n$")).forEach(e -> System.out.println(e.getName()));
        
        KafkaProducerImpl.produce();
        KafkaConsumerImpl.consume();

    }

    private static void printSnap(Camera c) {
        System.err.println(c.snapIt(new Color(125, 125, 125)));
    }

    public static int doWork(int value, Function<Integer, Integer> func) {
        return func.apply(value);
    }

    private static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
    }

    private static void doThis(Eatable e) {
        System.out.println(e.eat());
    }
    /**
     * 
     * @param c
     * @return 
     */
    private static List<Manager> find(Corporation c){
        return c.getDepartments()
                .stream()
                .filter(d -> d.getEmployees().stream().anyMatch(a -> a.getAge() > 65))
                .map(Department::getManager)
                .collect(Collectors.toList());
                
    }

}

interface Eatable {

    String eat();
}

class TimeIt {

    public static void run(Runnable r) {
        System.out.println("Running....");
        r.run();
        System.out.println("End Running....");
    }
}

class Camera {

    private final Function<Color, Color> filter;

    public Camera(Function<Color, Color>... filters) {
        filter = Stream.of(filters).reduce(Function.identity(), Function::andThen);
    }

    public Color snapIt(Color color) {
        return filter.apply(color);
    }
}

class Mailer {

    public Mailer from() {
        return this;
    }

    public Mailer to() {
        return this;
    }

    public Mailer subject() {
        return this;
    }

    public static void send(Consumer<Mailer> block) {
        Mailer mailer = new Mailer();
        block.accept(mailer);

        System.out.println("Sending .....");
    }

}

class FileClass {

    public static File[] getFiles() {
        File myDir = new File("/home/ubuntu/gulp-tutorial");
        return myDir.listFiles(File::isFile);
    }

}

interface Person{
    public enum Gender{MALE,FEMALE};
    public int getAge();
    public String getName();
    public Gender getGender();
}

interface Employee extends Person{
    public long getSalary();
}

interface Manager extends Employee{
    
}

interface Department{
    public enum Kind{SALES,DEVELOPMENT,ACCOUNTING,HUMAN_RESOURCES};
    
    public Kind getKind();
    public String getName();
    public Manager getManager();
    public Set<Employee> getEmployees();
}

interface Corporation{
    public Set<Department> getDepartments();
}
