
import java.util.concurrent.Semaphore; 
import java.util.ArrayList;
		
public class Main {
		
    public static void main(String[] args){
    	
    	//String p = "1. e4 e5 2. Nf3 Nc6 3. Bb5 a6 4. Ba4 Nf6 5. O-O Be7 6. Re1 b5 7. Bb3 O-O 8. c3 d6 9. h3 Nb8 10. d4 Nbd7 11. Nbd2 Bb7 12. Bc2 Re8 13. Nf1 Bf8 14. Ng3 g6 15. a4 Nb6 16. a5 Nbd7 17. b4 Bg7 18. d5 Rc8 19. Bb3 c6 20. dxc6 Rxc6 21. Qc2 Qc8 22. Qa2 Re7 23. Bb2 Bh6 24. Rad1 Bf4 25. Nf1 Rc7 26. N1d2 Qa8 27. Qb1 Nf8 28. c4 bxc4 29. Nxc4 Bxe4 30. Nb6 Qc6 31. Rxe4 Qxe4 32. Qxe4 Nxe4 33. Nd5 Red7 34. g3 Bh6 35. Re1 Nd2 36. Nxd2 Bxd2 37. Rd1 Bxb4 38. Nxb4 Rc5 39. Nxa6 Rxa5 40. Bc4 d5 41. Bd3 d4 42. Bc1 e4 43. Bc4 Ra1 44. Nc5 Rc7 45. Nb3 Rb1 46. Rxd4 Ne6 47. Bxe6 fxe6 48. Rxe4 Rxb3 49. Be3 Rc6 50. Ra4 Rb7 51. Kg2 Kf7 52. Ra5 Rd6 53. h4 Rd5 54. Ra8 Rbd7 55. Rh8 Kf6 56. Rf8+ Kg7 57. Re8 Kf7 58. Rh8 h5 59. Ra8 e5 60. Kf3 Ke6 61. Rg8 Kf7 62. Ra8 Rb5 63. Ra6 Rb4 64. Bg5 e4+ 65. Kg2 Rd1 66. Rf6+ Kg7 67. Re6 Ra4 68. Re7+ Kf8 69. Re6 Re1 70. Be3 Kf7 71. Re5 Rb4 72. Bd2";
    	//String p = "1. e4 c5 2. c4 e6 3. Nc3 Ne7 4. d3 Nbc6 5. Be3 Ng6 6. f4 d6 7. Nf3 Be7 8. a3 Bf6 9. Be2 O-O 10. O-O Bd4 11. Qd2 Nxf4 12. Nxd4 cxd4 13. Bxf4 e5 14. Nd5 exf4 15. Qxf4 Be6 16. Qg3 Bxd5 17. cxd5 Ne5 18. Rf2 Rc8 19. Bg4 Rc5 20. Raf1 Qg5 21. h3 Rc1 22. Kh2 Rxf1 23. Rxf1 Qd2 24. Rf2 Qe1 25. Rc2 Qb1 26. Rd2 g6 27. Qf2 h5 28. Bd1 Qc1 29. g4 hxg4 30. hxg4 Qxd1 31. Rxd1 Nxg4+ 32. Kg3 Nxf2 33. Kxf2 Rc8 34. Rd2 Kg7 35. Kf3 Rc1 36. Rh2 Kf6 37. Rh8 Rd1 38. Ke2 Rb1 39. Kf3 Rxb2 40. Re8 Rb6 41. e5+ dxe5 42. Ke4 Rd6 43. Rxe5 Rd7 44. Kxd4 g5 45. Re1 g4 46. Kc5 Kg5 47. d6 f5 48. Re7 Rd8 49. Kd5 Kf4 50. d7 g3 51. Rg7 Kf3 52. Ke5 g2 53. Ke6 f4 54. d4 Kf2 55. d5 g1=Q 56. Rxg1 Kxg1 57. Ke7 Rxd7+ 58. Kxd7 f3 59. Kc7 f2 60. d6 f1=Q 61. d7 Qd3 62. d8=Q Qxd8+ 63. Kxd8 b5 64. Kc7 a5 65. Kb6 b4 66. a4 b3 67. Kxa5 b2 68. Ka6 b1=Q 69. a5 Qb4";
    	//String p = "1. d4 Nf6 2. c4 e6 3. Nf3 d5 4. Nc3 dxc4 5. e4 b5 6. Nxb5 Nxe4 7. Qa4 c6 8. Nc3 Nxc3 9. bxc3 Ba6 10. Bxc4 Bxc4 11. Qxc4 Bd6 12. O-O O-O 13. Rb1 Qc7 14. Qd3 Nd7 15. c4 c5 16. d5 exd5 17. Qxd5 Nb6 18. Qd3 Rad8 19. Qc2 h6 20. a4 Rfe8 21. Be3 Bf4 22. a5 Nc8 23. Bxf4 Qxf4 24. Rfd1 Rxd1+ 25. Rxd1 Nd6 26. Qa4 Re6 27. Qd7 Ne4 28. Re1 a6 29. Qd8+ Kh7 30. Qd3 f5 31. g3 Rd6 32. Qb3 Qg4 33. Kg2 Qg6 34. Rd1 Rxd1 35. Qxd1 Qd6 36. Qb3 Qe6 37. Qd3 Qd6 38. Qe3 Qc7 39. Nh4 g6 40. Qd3 Qb7 41. Nf3 Kg7 42. Ne5 Kf6 43. Nd7+ Kf7 44. Nb6 Nf6+ 45. f3 Qe7 46. Nd5 Qd7 47. h4 g5 48. Qb3 Qe6 49. Qb7+ Kg6 50. Kf2 Nxd5 51. cxd5 Qf6 52. Qb6 Kf7 53. hxg5 hxg5 54. Qxc5 Qb2+ 55. Ke3 Qb3+ 56. Kd4 Qd1+ 57. Ke5 Qxf3 58. Qa7+ Kg6 59. Qxa6+ Kh5 60. Qe6 Qxg3+ 61. Kf6 Qc3+ 62. Qe5 Qxe5+ 63. Kxe5 f4 64. Ke4 Kg4 65. d6 f3 66. Ke3 Kg3 67. d7 f2 68. d8=Q f1=Q 69. Qxg5+ Kh3 70. Qh5+ Kg3 71. Qg6+ Kh3 72. Qd3 Qf8 73. a6 Qf7 74. Ke2+ Kg2 75. Qe4+ Kh2 76. Qh4+ Kg2 77. Qg5+ Kh2 78. Qe5+ Kg2 79. Qe4+ Kh2 80. Ke3 Qb3+ 81. Kf2 Qb6+ 82. Kf3 Qb3+ 83. Qe3 Qd5+ 84. Kf2 Qf5+ 85. Ke1 Qb1+ 86. Ke2 Qb5+ 87. Qd3 Qe5+ 88. Kd2 Qa5+ 89. Ke3 Qe5+ 90. Kf3 Qg3+ 91. Ke2 Qe5+ 92. Kd1 Qa1+ 93. Kd2 Qa2+ 94. Ke1 Qa1+ 95. Kf2 Qf6+ 96. Qf3 Qb6+ 97. Qe3 Qf6+ 98. Qf3 Qb6+ 99. Ke1 Qa5+ 100. Kf2 Qb6";
    	//String p = "1. d4 Nf6 2. c4 e6 3. Nf3 d5 4. Nc3 Bb4 5. cxd5 exd5 6. Bf4 c6 7. e3 Bf5 8. Qb3 Qb6 9. Nh4 Bg6 10. Nxg6 hxg6 11. h3 Nbd7 12. Bd3 c5 13. a3 Ba5 14. Qxb6 Bxb6 15. dxc5 Nxc5 16. O-O-O O-O-O 17. Kb1 Ne6 18. Be5 Bc7 19. Bxc7 Kxc7 20. Bc2 g5 21. Bb3 Kc6 22. Rc1 Kd6 23. Nb5+ Ke5 24. Nxa7 Ne4 25. Nb5 g4 26. Rc2 Rh5 27. f3 gxf3 28. gxf3 Ng3 29. Rd1 Nf5 30. Rc3 Ne7 31. Nc7 g5 32. Nxe6 fxe6 33. Rc7 Nf5 34. e4 Nd4 35. Rxb7 Rxh3 36. exd5 exd5 37. Re7+ Kd6 38. Re3 Nxb3 39. Rxb3 Rf8 40. Rdd3 Rf4 41. Kc2 Ke5 42. Rb5 Rd4 43. Rxd4 Kxd4 44. Rb3 Rh2+ 45. Kb1 Rh3 46. Ka2 Kc4 47. Rc3+ Kb5 48. Kb3 d4 49. Rd3 Kc5 50. Kc2 Rg3 51. a4 Rg2+ 52. Rd2 Rg3 53. Rf2 Kb4 54. b3 g4 55. fxg4 d3+ 56. Kd2 Rxg4 57. Kxd3 Rg3+ 58. Kc2 Rc3+ 59. Kb1 Rxb3+ 60. Rb2 Rxb2+ 61. Kxb2 Kxa4"; 	
    
    	
    	ArrayList<String> mosseBianco = new ArrayList<String>();
    	ArrayList<String> mosseNero = new ArrayList<String>();  
    	
    	String game = "1. e4 d5 2. exd5 Qxd5 3. Nc3 Qe6+ 4. Be2 Qg6 5. Bf3 Nc6 6. Nge2 Bg4 7. Bxg4 Qxg4 8. O-O O-O-O 9. d3 e5 10. h3 Qd7 11. a3 f5 12. b4 Nf6 13. b5 Nd4 14. a4 Bc5 15. Rb1 f4 16. Nxd4 Bxd4 17. Bd2 g5 18. b6 Bxb6 19. Nb5 a6 20. Na3 Bc5 21. Nc4 Qd5 22. Bc3 Rhe8 23. Re1 Bd4 24. Bxd4 Qxd4 25. c3 Qxc3 26. Qe2 e4 27. Rec1 Qd4 28. Qc2 exd3 29. Qb3 Kd7 30. Qxb7 Ke6 31. Na5 Qd5 32. Nc6 Rd6 33. Qxc7 Kf5 34. Ne7+ Rxe7 35. Qxe7 d2 36. Rd1 Kg6 37. Qe2 Qe4 38. Qxe4+ Nxe4 39. Rb2 Rd4 40. f3 Ng3 41. Rdxd2 Rxa4 42. Rd1 Kh5 43. Kf2 Kh4 44. Ke1 h5 45. Kd2 Nf5 46. Rc1 Ne3 47. Kd3 Ra5 48. Rc7 Kg3 49. Rg7 h4 50. Rb6 Nxg2 51. Rbg6 Ne1+ 52. Kc3 Nxf3 53. Kb4 Rb5+ 54. Kc4 Re5 55. Kd3 Kxh3 56. Rh6 Re3+ 57. Kc4 g4 58. Rf7 g3 59. Rxf4 g2 60. Rg6 g1=Q 61. Rxf3+ Rxf3 62. Rxg1 Rg3 63. Rh1+ Kg4 64. Ra1 h3 65. Ra4 h2 66. Kd5+ Kh3 67. Ke5 Rg5+ 68. Kf6 Rg4 69. Ra3+ Rg3 70. Ra5 Rg1 71. Rh5+ Kg2 72. Rg5+ Kf1 73. Rf5+ Ke2 74. Re5+ Kd3 75. Rd5+ Ke4 76. Rg5 h1=Q 77. Re5+ Kf4 78. Rf5+";
    	// link partita:  https://www.chess.com/it/games/view/15740397
    	
    	String[] array = game.split(" ");
        
        int w = 1, b = 2;
        
        for (int i=0; i<array.length; i++){
        	
            if (i == w) {
            	mosseBianco.add(array[i]);
            	w += 3;
            }
            
            if (i == b) {
            	mosseNero.add(array[i]);
            	b += 3;
            }
        }
        
        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);

        Scacchiera scacchiera = new Scacchiera();
        scacchiera.start();
        
        String idp1 = "Magnus Carlsen";
        String idp2 = "Rauf Mamedov";
        
        Giocatore bianco = new Giocatore(idp1, "Bianco", scacchiera, mosseBianco, s1, s2);
        Giocatore nero = new Giocatore(idp2, "Nero", scacchiera, mosseNero, s1, s2);

        System.out.println("\n || Simulazione partita scacchi ||");
        
        System.out.println("\n\n "+idp1+" è il bianco (β)");
        System.out.println(" "+idp2+" è il nero (Π)");
        
        System.out.println("\n Dopo che entrambi i due giocatori hanno mosso viene mostrata la scacchiera.");
        /* per vedere ogni singolo spostamento sulla scacchiera basta cancellare il controllo a riga 60 nella classe Giocatore*/
        
        scacchiera.printScacchiera();
        System.out.println(" > Scacchiera impostata, si può iniziare\n");
        
        System.out.println("\n\n");
        
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bianco.start();
        nero.start();
    }
}


