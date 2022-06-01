
import java.util.concurrent.Semaphore;
import java.util.ArrayList;
import java.util.Random;

public class Giocatore extends Thread {

    private Random rd;
    private String id;
    private String type;
    private Scacchiera scacchiera;
    private Semaphore s1;
    private Semaphore s2;
    private Cronometro cronometro;
    private ArrayList<String> mosse;

    public Giocatore(String id, String type, Scacchiera scacchiera, ArrayList<String>mosse, Semaphore s1, Semaphore s2){
    	
        rd = new Random();
        this.scacchiera = scacchiera;
        this.id = id;
        this.type = type;
        this.mosse = mosse;
        this.s1 = s1;
        this.s2 = s2;
        cronometro = new Cronometro();
    }

    private void play(){
    	
        for (int i=0; i<mosse.size(); i++){

            try {

                if (type.equals("Bianco")) {
                    s1.acquire();
                	System.out.println(" [ Mossa numero "+scacchiera.getMosse()+" ]\n");
                }else
                    s2.acquire();

            } catch (Exception e){
                e.printStackTrace();
            }
            
            cronometro.startC();
            
            //tempo : [0.300, 0.699] secondi
            try {
				sleep(rd.nextInt(50)+0);
			} catch (Exception e) {
				e.printStackTrace();
			}
            
            scacchiera.eseguiMossa(mosse.get(i), type);
            
            cronometro.stopC();
            
            System.out.println("  > "+id+" ("+type+"):\t"+mosse.get(i) + "\t tempo: "+cronometro.get()+" secondi");
            
            if (type.equals("Nero"))
            	scacchiera.mossaFatta();
            
            if (type.equals("Bianco"))
                s2.release();
            else
                s1.release();
        }
    }
   
    public void run(){

        play();
        
        try {
        	sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        scacchiera.finito(type);
    }
}



