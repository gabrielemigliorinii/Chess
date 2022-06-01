
import java.util.HashMap;

public class Scacchiera extends Thread {

    private static String[] lettere = {"A", "B", "C", "D", "E", "F", "G", "H"},
    						pedine = {"R", "N", "B", "Q", "K"};
    
    private static int[][][] moves = {
    		
		{{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{0,1},{0,-1},{-1,0}},   		// Regina e Re
		{{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{-2,1},{2,-1},{-2,-1}},  	// Cavallo
		{{1,1},{1,-1},{-1,1},{-1,-1}},									// Alfiere
		{{1,0},{0,1},{-1,0},{0,-1}}										// Torre
    };
    
    private HashMap<String, String> map = new HashMap<String, String>();	// esempio: <A8, 00> <B7, 11> <C2, 72>
    private int finito, mosse;
    private String[][] scacchiera = new String[8][8];
    
    public Scacchiera(){
    	finito = 0;
    	mosse = 1;
        setHMap();
        setScacchiera();
    }
    
    private void setHMap(){
        
        for (Integer riga=0; riga<8; riga++) 
            for (Integer colonna=0; colonna<8; colonna++) 
                map.put(lettere[colonna]+(8-riga), riga.toString()+colonna.toString());
    }

    private void setPedineNere(){

    	{
    	int i=0;
    	for (i=0; i<5; i++)
    		scacchiera[0][i] = pedine[i]+"Π";
    	for (int j=2; j>-1; j--)
    		scacchiera[0][i++] = pedine[j]+"Π";
    	}
        for (int i=0; i<8; i++)
        	scacchiera[1][i] = "PΠ";
    }

    private void setPedineBianche(){
    	
    	{
    	int i=0;
    	for (i=0; i<5; i++)
    		scacchiera[7][i] = pedine[i]+"β";
    	for (int j=2; j>-1; j--)
    		scacchiera[7][i++] = pedine[j]+"β";
    	}
        for (int i=0; i<8; i++)
        	scacchiera[6][i] = "Pβ";
    }

    private void setScacchiera(){

        for (int i=0; i<8; i++)
        	for (int j=0; j<8; j++)
        		scacchiera[i][j] = "  "; 

        setPedineBianche();
        setPedineNere();
    }
    
    public void mossaFatta() {
    	   
    	notifica();
    	aspetta();
    }
    
    private String typeOf(String in, String colore) {
    	
    	for (int i=0; i<pedine.length; i++)
    		if (pedine[i].equals(in))
    			return pedine[i]+colore;
    	
    	return "P"+colore;
    }
    
    private String getPosition(String mossa) {
    	
    	mossa = mossa.toUpperCase();
    	int len = mossa.length();
    	
    	if (mossa.substring(len-1, len).equals("+") || mossa.substring(len-1, len).equals("#"))
    		return mossa.substring(len-3, len-1);
    	else if (mossa.substring(len-2, len-1).equals("="))
    		return mossa.substring(0,2);
    	else return mossa.substring(len-2, len);
    }
    
    private void setEmptySpace(String mossa, int[][] m) {
    	
    	String l = mossa.substring(1,2).toUpperCase();
		String type = __type(l);
		
		if (type.equals("colonna")) {		
			if (lettere[m[0][1]].equals(l)) 
				scacchiera[m[0][0]][m[0][1]] = "  ";
			else 
				scacchiera[m[1][0]][m[1][1]] = "  ";
		}else {
			if ((Integer.valueOf(m[0][0]+1)).toString().equals(l)) 
				scacchiera[m[0][0]][m[0][1]] = "  ";
			else 
				scacchiera[m[1][0]][m[1][1]] = "  ";
		}
    }
    
    private String __type(String rc) {    	
    	
    	for (Integer i=1; i<9; i++)
    		if (i.toString().equals(rc))
    			return "riga";
    	return "colonna";
    }
    
    // metodo eseguito da pedone (P)
    private void P(int riga, int colonna, String pedina, String mossa) {
    	
    	if (mossa.substring(1,2).equals("x")) {
    		
    		String col = mossa.substring(0,1).toUpperCase();
    		
    		if (pedina.equals("Pβ")) 
    			riga++;			
    		else 
    			riga--;

    		if (lettere[colonna+1].equals(col)) 
				scacchiera[riga][colonna+1] = "  ";
			else	
				scacchiera[riga][colonna-1] = "  ";
    		
    	}else {
    		
    		int k = (pedina.equals("Pβ"))?1:-1;
			
			if (scacchiera[riga+k][colonna].equals(pedina))
				scacchiera[riga+k][colonna] = "  ";
			else
				scacchiera[riga+2*k][colonna] = "  ";
    	}
    }
    
    // metodo eseguito da cavallo (N) e re (K)
    private void NK(int riga, int colonna, String pedina, String mossa, int v) {
    	
    	int h = 0, tr = 0, tc = 0; 
    	int[][] m = new int[2][2];

    	for (int i=0; i<8; i++) {
    		
    		tr = riga;
    		tc = colonna;
    		
    		tr += moves[v][i][0];
    		tc += moves[v][i][1];
    		
    		if (tr < 0 || tr > 7 || tc < 0 || tc > 7)
    			continue;
    		
    		if (scacchiera[tr][tc].equals(pedina)) {
    			m[h][0] = tr;
    			m[h][1] = tc;
    			
    			h++;
    		}			
    	}
    	
		if (h==1) 
    		scacchiera[m[0][0]][m[0][1]] = "  ";
		else 
			setEmptySpace(mossa, m);
    }
    
    // metodo eseguito da alfiere (B), torre (R), regina (Q)
    private void BRQ(int riga, int colonna, String pedina, String mossa, int u, int v) {
    	    	
    	int h = 0;
    	int[][] m = new int[2][2];
    	
    	int tr = riga;
    	int tc = colonna;
    	
    	for (int i=0; i<u; i++) {
    		
    		tr = riga;
    		tc = colonna;
    		
	    	while (true) {
	    		
	    		tr += moves[v][i][0];
	    		tc += moves[v][i][1];
	    		
	    		if (tr < 0 || tr > 7 || tc < 0 || tc > 7)
	    			break;
	    		
	    		if (!scacchiera[tr][tc].equals("  ") && !scacchiera[tr][tc].equals(pedina))
	    			break;
	    		
	    		if (scacchiera[tr][tc].equals(pedina)) {
	    			
	    			m[h][0] = tr;
	    			m[h][1] = tc;
	    			
	    			h++;
	    			break;
	    		}
	    	}
    	}
    	
    	if (h == 1) 
    		scacchiera[m[0][0]][m[0][1]] = "  ";
    	else 
    		setEmptySpace(mossa, m);
    }
    
    private void arrocco(String chr, String tipo) {
    	
    	if (tipo.equals("O-O-O")) {
    		
    		int riga = (chr.equals("β"))?7:0;
    		
    		int colonnaK=0;
   
    		for (int colonna=0; colonna<8; colonna++) {
    			
    			if (scacchiera[riga][colonna].equals("K"+chr)) {
    				colonnaK = colonna;
    				break;
    			}
    		}
    		
    		int colonnaR = (colonnaK+4 > 7)?(colonnaK-4):(colonnaK+4);
    		
    		scacchiera[riga][colonnaK] = "  ";
    		scacchiera[riga][colonnaR] = "  "; 
    		
    		if (colonnaK > colonnaR) {
    			colonnaK -= 2;
    			colonnaR += 3;
    		}else {
    			colonnaK += 2;
    			colonnaR -= 3;
    		}
    		
    		scacchiera[riga][colonnaK] = "K"+chr;
    		scacchiera[riga][colonnaR] = "R"+chr;
    		
    	}else {
	    	
	    	int king=0;
	    	int rook=0;
	    	int[] array = {-1,-1};
	    	int riga = (chr.equals("β"))?7:0;
	    	
	    	for (int colonna=0; colonna<8; colonna++)
	    		if (scacchiera[riga][colonna].equals("K"+chr))
	    			king = colonna;
	    	
	    	array[0] = king-3;
	    	array[1] = king+3;
	    	
			if (array[0] < 0 || array[0] > 7)
				array[0] = -1;
			if (array[1] < 0 || array[1] > 7) 
				array[1] = -1;	
			
			if (array[0] > 0 && array[1] > 0)	
				rook = (scacchiera[riga][array[0]].equals("R"+chr))?array[0]:array[1];
			else 
				rook = (array[0] > 0)?array[0]:array[1];
			
			
			scacchiera[riga][king] = "  ";
			scacchiera[riga][rook] = "  ";
			
			if (king > rook) {
				king-=2;
				rook+=2;
			}else {
				king+=2;
				rook-=2;
			}
			
			scacchiera[riga][king] = "K"+chr;
			scacchiera[riga][rook] = "R"+chr;
    	}
    }
    
    private void promozione(int riga, int colonna, String pedina) {
    	
    	scacchiera[riga][colonna] = pedina;
    	scacchiera[riga+((pedina.substring(1,2).equals("β"))?1:-1)][colonna] = "  ";
    }
    
    public void eseguiMossa(String mossa, String colore) {
    	
    	String pedina;
    	int len = mossa.length();
    	String chr = (colore.equals("Bianco"))?"β":"Π";
    
    	if (mossa.equals("O-O") || mossa.equals("O-O-O"))
    		arrocco(chr, mossa);		
    	else {
    		
    		String position = getPosition(mossa);
	    	int riga = Integer.parseInt(map.get(position).substring(0,1));
	    	int colonna = Integer.parseInt(map.get(position).substring(1,2));
    		
	    	if (mossa.substring(len-2,len-1).equals("=")) {
	    		
	    		pedina = typeOf(mossa.substring(len-1,len), chr);
	    		promozione(riga, colonna, pedina);
	    		return;
	    	}else
	    		pedina = typeOf(mossa.substring(0,1), chr);
	   
	    	scacchiera[riga][colonna] = pedina;
	    	
	    	switch (pedina.substring(0,1)) {
	    		
		    	case "P":
		    		P(riga, colonna, pedina, mossa);
		    	break;
		    	
		    	case "N":
		    		NK(riga, colonna, pedina, mossa, 1);
		    	break;
		    	
		    	case "K":
		    		NK(riga, colonna, pedina, mossa, 0);
		    	break;
		    	
		    	case "B":
		    		BRQ(riga, colonna, pedina, mossa, 4, 2);
		    	break;
		    			    	
		    	case "R":
		    		BRQ(riga, colonna, pedina, mossa, 4, 3);
		    	break;
		    	
		    	case "Q":
		    		BRQ(riga, colonna, pedina, mossa, 8, 0);
	    	}
    	}
    }
    
    public void printScacchiera() {
    	
        System.out.print("\n\n ");
        
        for (int k=48; k<47; k++)
        	System.out.print("_");
        
        System.out.print("\n\n\n");
    	
        String intestazioneRigaPrima = "      A    B    C    D    E    F    G    H";
        String separatoreRigaPrima =   "    ┌────┬────┬────┬────┬────┬────┬────┬────┐";
        String separatoreRiga =        "    ├────┼────┼────┼────┼────┼────┼────┼────┤";
        String separatoreRigaUltima =  "    └────┴────┴────┴────┴────┴────┴────┴────┘";
        
        for (int riga=0;riga<8;riga++){
        	
            if (riga==0){
            	
                System.out.println(intestazioneRigaPrima);
                System.out.println(separatoreRigaPrima);
            }else 
                System.out.println(separatoreRiga);
            
          System.out.print("  "+(8-riga));      
          System.out.print(" ");      
          for (int colonna=0;colonna<8;colonna++){
              if (colonna==0) System.out.print("│");
              System.out.print("");
              System.out.print(" "+scacchiera[riga][colonna]);
              System.out.print(" ");
              System.out.print("│");
             
            }
          System.out.print(" ");      
          System.out.print(8-riga);      
          System.out.println();
        }
         
        System.out.println(separatoreRigaUltima);
        System.out.println(intestazioneRigaPrima);
        
        System.out.print("\n ");
        for (int k=0; k<80; k++)
        	System.out.print("_");
        
        System.out.print("\n\n");
    }
    
    public synchronized void finito(String type) {
    	finito++;
    	if (finito==2) {
    		
    		if (type.equals("Bianco"))
    			printScacchiera();
    		
    		notify();
    	}
    }
    
    public int getMosse() {
    	return mosse;
    }
    
    private synchronized void notifica() {
    	notify();
    }
    
    private synchronized void aspetta() {
		try {
			wait();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    public void run() {
    	    	
    	while (true) {
    		
    		aspetta();
    								
    		if (finito != 2) {
    			mosse++;
    			printScacchiera();
    			System.out.println("\n");
    				
    	    	try {
    				Thread.sleep(50);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    	    	
    	    	notifica();
    			
    		}else break;
    	}
		System.out.println("\n\n > La partità è finita\n");
    }
}
