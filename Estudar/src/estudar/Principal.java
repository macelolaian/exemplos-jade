
package estudar;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.util.ExtendedProperties;
import jade.util.leap.Properties;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        AgentContainer ac = null;

        ProfileImpl p = null;
        Properties props = new ExtendedProperties();
        p = new ProfileImpl(props);
        props.setProperty(Profile.GUI, "true");

        jade.core.Runtime.instance().setCloseVM(true);
        if (p.getBooleanProperty(Profile.MAIN, true)) {
            ac = jade.core.Runtime.instance().createMainContainer(p);
        } else {
            jade.core.Runtime.instance().createAgentContainer(p);
        }
        
        try {
        /*    AgentController Alarmado = ac.createNewAgent("Alarmado", "agentes.AgenteAlarmado", new String[]{"arg1", "arg2"});
            Alarmado.start();
            
            AgentController Bombeiro = ac.createNewAgent("Bombeiro", "agentes.AgenteBombeiro", new String[]{"arg1", "arg2"});
            Bombeiro.start();            
        */        
            AgentController PessoaMacelo = ac.createNewAgent("Macelo", "agentes.Pessoa", new String[]{"arg1", "arg2"});
            PessoaMacelo.start();
            
            AgentController PessoaJanea = ac.createNewAgent("Janea", "agentes.Pessoa", new String[]{"arg1", "arg2"});
            PessoaJanea.start();
            
        
        } catch (StaleProxyException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//Fim main
    
}//Fim principal

