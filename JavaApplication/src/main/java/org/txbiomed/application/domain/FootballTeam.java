/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.txbiomed.application.domain;

/**
 *
 * @author lkacimi
 */
class FootballTeam implements Comparable<FootballTeam> {

    private int gamesWon;
    public FootballTeam(int i) {
        this.gamesWon = i;
    }

    public int getGamesWon() {
        return this.gamesWon;
    }
    
    public void setGamesWon( int gamesWon){
        this.gamesWon = gamesWon;
    }

    @Override
    public int compareTo(FootballTeam team) {
        return this.getGamesWon() - team.getGamesWon();
    }
    
    
}
