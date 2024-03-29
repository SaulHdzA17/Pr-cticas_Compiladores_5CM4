public class Tabla {
    
    public String [] [] tabla = new String [ 11 ] [ 8 ];
     
     public Tabla(){


        /*
     * 
     * 
     * 
     *                     select D from T  distinct P | P    * | A     A2 A1   , A | Ɛ   id A3   . id | Ɛ    T2 T1 , T | Ɛ
     *         this.tabla [ x ] [ y ]  
     *                            0        1      2     3   4   5   6   7
     *                          select   from  distinc  *   ,   .   id  $(EOF) 
     *         0            Q  
     *         1            D  
     *         2            P
     *         3            A
     *         4            A1
     *         5            A2
     *         6            A3
     *         7            T
     *         8            T1
     *         9            T2
     *         10           T3
     * 
     * 
     */
        
        /********* Producciones con Q **********/
        this.tabla [ 0 ] [ 0 ] = "select D from T";
        this.tabla [ 0 ] [ 1 ] = "#";
        this.tabla [ 0 ] [ 2 ] = "#";
        this.tabla [ 0 ] [ 3 ] = "#";
        this.tabla [ 0 ] [ 4 ] = "#";
        this.tabla [ 0 ] [ 5 ] = "#";
        this.tabla [ 0 ] [ 6 ] = "#";
        this.tabla [ 0 ] [ 7 ] = "#";

        /********* Producciones con D **********/
        this.tabla [ 1 ] [ 0 ] = "#";
        this.tabla [ 1 ] [ 1 ] = "#";
        this.tabla [ 1 ] [ 2 ] = "distinct P";
        this.tabla [ 1 ] [ 3 ] = "P";
        this.tabla [ 1 ] [ 4 ] = "#";
        this.tabla [ 1 ] [ 5 ] = "#";
        this.tabla [ 1 ] [ 6 ] = "P";
        this.tabla [ 1 ] [ 7 ] = "#";

        /********* Producciones con P **********/
        this.tabla [ 2 ] [ 0 ] = "#";
        this.tabla [ 2 ] [ 1 ] = "#";
        this.tabla [ 2 ] [ 2 ] = "#";
        this.tabla [ 2 ] [ 3 ] = "*";
        this.tabla [ 2 ] [ 4 ] = "#";
        this.tabla [ 2 ] [ 5 ] = "#";
        this.tabla [ 2 ] [ 6 ] = "A";
        this.tabla [ 2 ] [ 7 ] = "#";

        /********* Producciones con A **********/
        this.tabla [ 3 ] [ 0 ] = "#";
        this.tabla [ 3 ] [ 1 ] = "#";
        this.tabla [ 3 ] [ 2 ] = "#";
        this.tabla [ 3 ] [ 3 ] = "#";
        this.tabla [ 3 ] [ 4 ] = "#";
        this.tabla [ 3 ] [ 5 ] = "#";
        this.tabla [ 3 ] [ 6 ] = "A2 A1";
        this.tabla [ 3 ] [ 7 ] = "#";

        /********* Producciones con A1 **********/
        this.tabla [ 4 ] [ 0 ] = "#";
        this.tabla [ 4 ] [ 1 ] = "E";
        this.tabla [ 4 ] [ 2 ] = "#";
        this.tabla [ 4 ] [ 3 ] = "#";
        this.tabla [ 4 ] [ 4 ] = ", A";
        this.tabla [ 4 ] [ 5 ] = "#";
        this.tabla [ 4 ] [ 6 ] = "#";
        this.tabla [ 4 ] [ 7 ] = "#";
        
        /********* Producciones con A2 **********/
        this.tabla [ 5 ] [ 0 ] = "#";
        this.tabla [ 5 ] [ 1 ] = "#";
        this.tabla [ 5 ] [ 2 ] = "#";
        this.tabla [ 5 ] [ 3 ] = "#";
        this.tabla [ 5 ] [ 4 ] = "#";
        this.tabla [ 5 ] [ 5 ] = "#";
        this.tabla [ 5 ] [ 6 ] = "id A3";
        this.tabla [ 5 ] [ 7 ] = "#";

        /********* Producciones con A3 **********/
        this.tabla [ 6 ] [ 0 ] = "#";
        this.tabla [ 6 ] [ 1 ] = "E";
        this.tabla [ 6 ] [ 2 ] = "#";
        this.tabla [ 6 ] [ 3 ] = "#";
        this.tabla [ 6 ] [ 4 ] = "E";
        this.tabla [ 6 ] [ 5 ] = ". id";
        this.tabla [ 6 ] [ 6 ] = "#";
        this.tabla [ 6 ] [ 7 ] = "#";

        /********* Producciones con T **********/
        this.tabla [ 7 ] [ 0 ] = "#";
        this.tabla [ 7 ] [ 1 ] = "#";
        this.tabla [ 7 ] [ 2 ] = "#";
        this.tabla [ 7 ] [ 3 ] = "#";
        this.tabla [ 7 ] [ 4 ] = "#";
        this.tabla [ 7 ] [ 5 ] = "#";
        this.tabla [ 7 ] [ 6 ] = "T2 T1";
        this.tabla [ 7 ] [ 7 ] = "#";

        /********* Producciones con T1 **********/
        this.tabla [ 8 ] [ 0 ] = "#";
        this.tabla [ 8 ] [ 1 ] = "#";
        this.tabla [ 8 ] [ 2 ] = "#";
        this.tabla [ 8 ] [ 3 ] = "#";
        this.tabla [ 8 ] [ 4 ] = ", T";
        this.tabla [ 8 ] [ 5 ] = "#";
        this.tabla [ 8 ] [ 6 ] = "#";
        this.tabla [ 8 ] [ 7 ] = "E";

        /********* Producciones con T2 **********/
        this.tabla [ 9 ] [ 0 ] = "#";
        this.tabla [ 9 ] [ 1 ] = "#";
        this.tabla [ 9 ] [ 2 ] = "#";
        this.tabla [ 9 ] [ 3 ] = "#";
        this.tabla [ 9 ] [ 4 ] = "#";
        this.tabla [ 9 ] [ 5 ] = "#";
        this.tabla [ 9 ] [ 6 ] = "id T3";
        this.tabla [ 9 ] [ 7 ] = "#";

        /********* Producciones con T3 **********/
        this.tabla [ 10 ] [ 0 ] = "#";
        this.tabla [ 10 ] [ 1 ] = "#";
        this.tabla [ 10 ] [ 2 ] = "#";
        this.tabla [ 10 ] [ 3 ] = "#";
        this.tabla [ 10 ] [ 4 ] = "#";
        this.tabla [ 10 ] [ 5 ] = "#";
        this.tabla [ 10 ] [ 6 ] = "id";
        this.tabla [ 10 ] [ 7 ] = "E";

    }

}