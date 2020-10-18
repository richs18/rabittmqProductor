import java.util.ArrayList;

public class main {

    private static final  int chunk_size =100;
    public static void main(String[] args) {

        leer le= new leer();
        ArrayList<String> datos = le.leerTxt("C:\\Users\\RICHD18\\IdeaProjects\\productor\\archivos necesarios/datos.txt");
        for(int i=0;i<datos.size();i++){
            //System.out.println("estos son los datos"+datos.get(i));
        }


        int chunks = (int) Math.floor(datos.size()/ chunk_size);
        System.out.println("este es el chunks"+chunks);
        int m=0;
        String nombre="proceso";
        for (int i = 0; i < chunks; i++) {
            ArrayList<String> dat = new ArrayList<String>();
            for (int j = 0; j < chunk_size; j++) {
                dat.add(datos.get(m));
                m+=1;

               // System.out.println("estos son los datos de dat"+dat.get(j));
            }

            productor pro = new productor(dat);

            Thread hilos = new Thread(pro);
            hilos.start();

            System.out.println("aqui se limpio el arraylist");
            dat.clear();

        }


    }


}
