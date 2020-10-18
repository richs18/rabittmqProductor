
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class leer {

    public ArrayList<String> leerTxt(String direccion){// recibe direccion del archivo a leer

        String[] texto =null;
        String separador=",";
        ArrayList<String> dat = new ArrayList<String>();

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));

            String temp ="";
            String bfRead;
            while((bfRead =bf.readLine())!= null){

                System.out.println("estos son los datos de bf read "+bfRead);
                temp =  Arrays.toString(bfRead.split(separador));
                dat.add(temp);
                //texto[] =  Arrays.toString(bfRead.split(separador));
                //System.out.println("estos son los datos de temp"+ temp);
                //texto[contador] = temp;
            }

            //texto[0]="hola si salgo al otro lado";
            // dat.add(temp);




        } catch (IOException e) {
            System.out.println("no se encontro el archivo");
        }



        return dat;

    }
}
