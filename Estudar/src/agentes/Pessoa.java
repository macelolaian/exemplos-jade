/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.TickerBehaviour;
import jade.core.behaviours.WakerBehaviour;
import java.util.Date;

/**
 *
 * @author macelo
 */
public class Pessoa extends Agent{

    @Override
    protected void setup(){
        Object[] args = getArguments();
        
        addBehaviour(new CompBehaviour());
    }
    
    // comportamento padrão Behaviour
    private class CompBehaviour extends Behaviour{
        int i = 1;        
        
        @Override
        public void action() {
            System.out.println("Sou o agente " + myAgent.getLocalName() + ", estou falando isso pela " + i + "º vez!");
            i++;
        }

        @Override
        public boolean done() {
            if(i < 4){
                return false;
            }else{
                return true;
            }
        }
    }
    
    private class CompOneShot extends OneShotBehaviour{

        @Override
        public void action() {
            System.out.println(
                "Executando comportamento OneShot."
            );            
        }        
    }
    
    private class CompCyclic extends CyclicBehaviour{

        int i = 1;
        @Override
        public void action() {
            System.out.println(
                "Executando comportamento Cyclic pela " + i + "º vez."
            );
            i++;
        }        
    }
    
    private class CompWaker extends WakerBehaviour{
        
        public CompWaker(Agent a, long delay) {
            super(a, delay);
        }
        
        @Override
        protected void onWake(){
            System.out.println(
                "Executando comportamento Waker."
            );
        }
    }
    
    private class CompTicker extends TickerBehaviour{
        
        public CompTicker(Agent a, long delay) {
            super(a, delay);
        }

        @Override
        protected void onTick() {
            System.out.println(
                "Executando comportamento Waker pela " + getTickCount () + "º vez"
            );
        }        
    }
}