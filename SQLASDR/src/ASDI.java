import java.util.List;
import java.util.Stack;

public class ASDI implements Parser{

    private int i = 0, noTerminal = 0, terminal = 0;
    private boolean hayErrores = false;
    private Token preanalisis;
    private final List<Token> tokens;
    private final Tabla ta = new Tabla();
    private String produccion = "", item = "";
    //private static List<Token> auxItem;
    private Stack<String> pila = new Stack<>(); //Decalracion de la pila
        

    //Ejemplo para acceder a los incides de la tabla String a = this.ta.tabla[ noTerminal ][ terminal ];

    public ASDI(List<Token> tokens){
        this.tokens = tokens;
        preanalisis = this.tokens.get(i);
    }

    @Override
    public boolean parse() {

        //Definimo la pila con 2 caracteres iniciales
        //Stack<String> pila = new Stack<>(); //Decalracion de la pila
        this.pila.push("$"); //Primer item (ultimo en salir): $. Indica el final de la cadena.
        this.pila.push("Q"); //Siguinte item: Q. Axioma de la gramatica.
        this.item = pila.pop();
        //this.preanalisis = this.tokens.get(i);
        
        while( !pila.empty() ){//Miestras la pila no este vacia

            if( this.hayErrores ) return false;//Se checa que no haya errores

            //Comprobar que item es un noTerminal
            if( ( item.equals("Q") )  || ( item.equals("D") )  || ( item.equals("P") ) || ( item.equals("A") )  || ( item.equals("A1") ) ||
                ( item.equals("A2") ) || ( item.equals("A3") ) || ( item.equals("T") ) || ( item.equals("T1") ) || ( item.equals("T2") ) ||
                ( item.equals("T3") ) ){

                System.out.println("****Primer caso****");
                //Concideramos que es un No terminal
                //Buscar indices
                System.out.println("Indices\nItem: " + item + " Preanalisis: " + preanalisis );
                this.buscarIndices(item, this.preanalisis);
                if(hayErrores) break;//Se checa que los indices se hayan encontrado
                //Asignamos produccion
                this.Produccion();
                System.out.println("Produccion: " + item + " -> " + produccion);
                //Agregamos a la pila de manera inversa
                this.addPilaInv();
                this.item = pila.pop();//Reapuntamos al tope de la pila
                System.out.println( "Item " + this.item );
                System.out.println("------Fin primer caso------"); 

            }else if( ( ( item.equals("select") ) && ( this.preanalisis.tipo.equals(TipoToken.SELECT) ) ) 
                   || ( ( item.equals("from") )   && ( this.preanalisis.tipo.equals(TipoToken.FROM) ) ) 
                   || ( ( item.equals("distinct")) && ( this.preanalisis.tipo.equals(TipoToken.DISTINCT) ) )
                   || ( ( item.equals("*") )      && ( this.preanalisis.tipo.equals(TipoToken.ASTERISCO) ) ) 
                   || ( ( item.equals(",") )      && ( this.preanalisis.tipo.equals(TipoToken.COMA) ) )
                   || ( ( item.equals("." ))      && ( this.preanalisis.tipo.equals(TipoToken.PUNTO) ) )
                   || ( ( item.equals("id") )     && ( this.preanalisis.tipo.equals(TipoToken.IDENTIFICADOR) ) )
                   || ( ( item.equals("$") )      && ( this.preanalisis.tipo.equals(TipoToken.EOF) ) ) ){    
                
                //Si son iguales
                
                System.out.println("*****Segundo caso******");
                System.out.println("Reapuntamos el inico de la pila y el siguiente token");
                System.out.println("Item: " + item + " Preanalisis: " + preanalisis );
                
                item = pila.pop(); //Sacamos de la pila
                i++;//Avanzamos uno en la lista de tokens
                this.preanalisis = this.tokens.get(i); //Tomamos el siguiente token 
                System.out.println("Item: " + item + " Preanalisis: " + preanalisis );
                System.out.println("------Fin segundo caso------"); 

            }else if( item.equals("E") ){

                //No se inserta nada en la pila (se saca el tope de la pila)

                System.out.println("*****Terce caso****");
                System.out.println("Reapuntamos el inico de la pila");
                System.out.println("Item: " + item + " Preanalisis: " + preanalisis );
                item = pila.pop(); //Sacamos de la pila
                System.out.println("Item: " + item + " Preanalisis: " + preanalisis );
                System.out.println("------Fin tercer caso------"); 


            }else if( item.equals("#") ){

                System.out.println("*******Caso de error******");
                //La istaxis no es correcta
                this.hayErrores = true;
                System.out.println("La sintaxis es incorrecta.Token: " + this.preanalisis.lexema + ".Tipo: " + this.preanalisis.tipo + ".Posicion: " + this.preanalisis.posicion );
                System.out.println("Item: " + item + " Preanalisis: " + preanalisis );
                System.out.println("------Fin caso de error------");

            }else{

                System.out.println("*******Default*****");
                System.out.println("Item: " + item);
                System.out.println("Lexema: "+ this.preanalisis.lexema + " Tipo: " + this.preanalisis.tipo );
                if (  ( item.equals("select") ) && ( this.preanalisis.tipo.equals(TipoToken.SELECT) ) ){
                    System.out.println( "Son iguales" );
                    return false;
                }
                System.out.println( "No son iguales" );
                System.out.println("------Fin default------");
                return false;

            }

            //Imprimir pila
            System.out.println(">>>>>>>>>>Imprimir pila<<<<<<<<<");
            for (String elemento : pila) System.out.println("->" + elemento);
            System.out.println("Tope de la pila: " + item);
          
            
        }

        if( preanalisis.tipo == TipoToken.EOF && !hayErrores && this.pila.isEmpty() ){
            System.out.println("Consulta correcta");
            return  true;
        }else {
            System.out.println("Se encontraron errores");
            
        }
        return false;
    
    }

    public void buscarIndices( String noTerminal, Token terminal  ){

        //No terminales ( Q D P A A1 A2 A3 T T1 T2 T3 )
        switch (noTerminal) {
            
            case "Q":
                this.noTerminal = 0;
            break;

            case "D":
                this.noTerminal = 1;
            break;
            
            case "P":
                this.noTerminal = 2;
            break;
            
            case "A":
                this.noTerminal = 3;
            break;
            
            case "A1":
                this.noTerminal = 4;
            break;

            case "A2":
                this.noTerminal = 5;
            break;

            case "A3":
                this.noTerminal = 6;
            break;

            case "T":
                this.noTerminal = 7;
            break;

            case "T1":
                this.noTerminal = 8;
            break;

            case "T2":
                this.noTerminal = 9;
            break;

            case "T3":
                this.noTerminal = 10;
            break;
            
            default:
                //Mandar error
                hayErrores = true;
                System.out.println("Error. Indice (noTerminal) no encontrado");
            break;
        
        }

        //Terminales ( select from distinc * , . id $ )
        switch (terminal.tipo) {
            
            case SELECT:
                this.terminal = 0;
            break;

            case FROM:
                this.terminal = 1;
            break;

            case DISTINCT:
                this.terminal = 2;
            break;

            case ASTERISCO:
                this.terminal = 3;
            break;

            case COMA:
                this.terminal = 4;
            break;

            case PUNTO:
                this.terminal = 5;
            break;

            case IDENTIFICADOR:
                this.terminal = 6;
            break;

            case EOF:
                this.terminal = 7;
            break;

            default:
                //Mandar error
                hayErrores = true;
                System.out.println("Error. Indice (Terminal) no encontrado");
            break;
        
        }        

    }

    public void Produccion(){

        //Asignamos la producdión
        this.produccion = this.ta.tabla [ this.noTerminal ] [ this.terminal ];      

    }

    public void addPilaInv(){

        System.out.println("+++++++++++Inicio de addPilaInv++++++++++++");
        //Añadimos a la pila de manera inversa
        char c; //Caracter para distinuir las palabras de la producción
        String aux = ""; //Para insertas las palabras en las listas
        int x = this.produccion.length() - 1;//Le asignamos la longitud de lexema
       
        //System.out.println( " sadfasdgfasdfasdfasdfasdf" );
               
        while( x >= 0 ){//Miesntras que x  no haya llegado al inico de la produccion

           
            c = this.produccion.charAt(x);//Len asignamos el ultimo caracter del lexema

            if ( ( c == ' ' ) || ( x == 0 ) ) {
                
                //Se debe invertir y guardad

                if( x == 0 ) aux+=c;

                System.out.println("Antes de reverse: "+ aux);
                this.pila.push(this.reverse(aux));
                aux = "";
                System.out.println("Inicio de la pila: "+ pila.peek());

            }else{
                
                //sigue leyendo
                aux+=c;
                System.out.println("X = "+ x + " Aux = "+ aux);
            
            }

            x--;

        }


    }

    public String reverse( String cadena ){

        // Invertir la cadena usando bucle y concatenación
        String invertida = "";
        for ( int i = cadena.length() - 1; i >= 0; i-- ) {
            invertida += cadena.charAt(i);
        }

        return invertida;

    }

}
