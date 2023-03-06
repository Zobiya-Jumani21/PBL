import Stack.StacK;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// stack class
 class ArrayStack implements StacK {
    public Object[] a;
    public int size;
    public ArrayStack(int cap) {
        a = new Object[cap];
    }
    // imEmpty Method
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }
    public String toString(ArrayStack s1) {
        String data="[ ";

        for (int i=s1.size-1; i>=0; i--) {
            data = data + s1.a[i]; // concatenate data
            if (i >0) {
                data = data +" ,";
            }
        }
        return data +" ]";
    }
    @Override
    public Object peek(){
        if (size==0)throw new IllegalStateException("Stack empty");

        return a[size-1]; // because it is arrayed peek mean value take out
    }
    public Object pop(){ // delete the element
        if (size==0)throw new IllegalStateException("Stack empty");{
        }
        Object obj=a[--size];
        a[size]=null;
        return obj;
    }
    public Object popLastElement(){ // delete the last element in stack
        if (size==0)throw new IllegalStateException("Stack empty");{
        }
        Object obj=a[0];
        a[0]=null;

        System.arraycopy(a,1,a,0,--size);
        return obj;
    }
    public void push(Object obj){
        if (size==a.length)
            resize();
        a[size++]=obj;
    }
    private void resize(){
        Object[] aa=a;
        a=new Object[2*aa.length];
        System.arraycopy(aa,0,a,0,size);
    }
    public int size(){
        return size;
    }
    public boolean equalMethod( ArrayStack one,ArrayStack two){
        if (size==0) throw new IllegalStateException("Stack empty");
        if (one.a[size-1].equals(two.a[size-1])){
            return true;
        }
        else {
            return false;
        }
    }
    public ArrayStack copyStack(ArrayStack s1){
        ArrayStack s2 = new ArrayStack(s1.size);
        for (int i=size-1; i>=0; i--) {
            s2.push(s1.a[i]);
        }
        return s2;
    }
}
// stack class end
public class CSVReaderPakUni {
    public static void main(String[] args) {
// four keywords of universities
        String[] array={"ABAU" ,"AWKU" , "AGAK" , "AIRU" , "BAKU" , "BAHZ" , "BAHU" , "BUIT", "BAQU", "BHNU" ,
                "CECO", "CIIT" , "DWET" , "DUHS", "FJMU" , "FJWU" , "FEDU" , "FORC" , "FOUN" , "GIKI" , "GMAL" , "GMUS" ,
                "GCUF" , "GCUL" , "GCWF","HAMD", "HAZR", "HITC" , "INDS" , "INTU" , "INBA" , "IOST" ,
                "IIUI" , "IQRA" , "ICPS" , "IUOB" , "ISRA" , "JSMu" , "JUFW" , "KIET" , "KRIU" , "KHYB" , "KEMU" , "KCFW" ,
                "KUST" , "LCWT" , "LSOE" , "LOMS" , "LUMS" , "MUET" , "MUST" , "MAJU" , "NBAE" , "NDEU" , "NTEX" , "NCES" ,
                "NUML" , "NSAT" , "NEDU" , "PIDE" , "PIAS" , "PMAS" , "PRES" , "QUES" , "QIAU" , "PAMU" , "PIIU" , "SSIT" ,
                "SALU" , "SBBW" , "SZAB" , "SAGU" , "SMIU" , "SSET" , "SIBA" , "UAGF" , "UAGP" , "UAJK" , "UOBL" , "UOCP" ,
                "UOEP" , "UETL" , "UETP" , "UETT" , "UGUJ" , "HARI" , "UHSL" , "KARA" , "LAHR" , "MALK" , "UMTL" , "UPSH" ,
                "USAR" , "USTB" , "USID" , "USWT" , "UOTP" , "UVAS" , "UOWH" , "ZIAD"};

        ArrayStack a1 = new ArrayStack(30); // for the pulication
        ArrayStack rank = new ArrayStack(99); // for the pakRank
        String path="C:\\Users\\Fattani Computers\\Desktop\\universities.csv";
        List<paku> uni=readcsv(path);

        int i=0;
        HashMap<String,paku> map = new HashMap<>();

        for (paku b : uni){
            map.put(array[i],b);
            i=i+1;}

        // for copy the publication value
        int[] pubvalue= new int[array.length];
        for (int j=0; j< pubvalue.length; j++) {
            pubvalue[j] = Integer.parseInt(map.get(array[j]).pub);
       }

       // sort the publication value by insertion sort
        for (int j=0; j< pubvalue.length-1; j++){
            int minimum=j;
            for (int k=j+1; k< pubvalue.length; k++){
                if (pubvalue[minimum]>pubvalue[k]){
                    minimum=k;
                }
            }
            int temp=pubvalue[minimum];
            pubvalue[minimum]=pubvalue[j];
            pubvalue[j]=temp;
        }
int[] copy=new int[pubvalue.length];
int count=0;
        for (int z=0; z<= pubvalue.length; z++ ){
            if (count== 100){break;}
            if (z== 100) {z = 0;}
            if (map.get(array[z]).pub.equals(String.valueOf(pubvalue[count]))){
                a1.push(array[z]);
                copy[z]= Integer.parseInt(map.get(array[z]).pub); // I copy  the publication  from the map because in compare I delete one by one valur from map
                map.get(array[z]).pub="null";
                count++;
                z=0;
            }
        }
        for (int m=0; m<copy.length; m++){
            map.get(array[m]).pub= String.valueOf(copy[m]);
        }

        // start the pakRank Algorithm from here
        // for copy the pakistani rank value

        int[] pakRank = new int[array.length];


        for (int j=0; j< pakRank.length; j++) {
            pakRank[j]= Integer.parseInt(map.get(array[j]).pakRank.substring(0,map.get(array[j]).pakRank.indexOf(" ")));

        }

        // then sort the value by insertion sorting
        for (int j=0; j< pakRank.length-1; j++){
            int minimum=j;
            for (int k=j+1; k< pakRank.length; k++){
                if (pakRank[minimum]>pakRank[k]){
                    minimum=k;
                }
            }
            int temp=pakRank[minimum];
            pakRank[minimum]=pakRank[j];
            pakRank[j]=temp;
        }//

        int num=0;
        for (int z=0; z<=pakRank.length; z++ ){
            if (num== 100){break;}
            if (z== 100) {z = 0;}

            if (map.get(array[z]).pakRank.substring(0,map.get(array[z]).pakRank.indexOf(" ")).equals(String.valueOf(pakRank[num]))){
                rank.push(array[z]);
                num++;
                z=0;
            }
        }

    } // main method

    // method jis men data from csv file se objects men save hoti ja rahi hai
    private static  paku createUni(String[] data){

        String name=data[0];
        String wRank=data[1];
        String asiaRank= data[2];
        String pakRank=data[3];
        String loc=data[4];
        String pub=data[5];

        return new paku(name,wRank,asiaRank,pakRank,loc,pub);
    }

   static List<paku>  readcsv(String path){
        List<paku> unis=new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line= br.readLine();
            while (line!=null){
                String[] attributes=line.split(",");

                paku uni=createUni(attributes);
                unis.add(uni);

                line= br.readLine();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return unis;
    }
}
// pakistan university class
class paku{
    String name,wRank,asiaRank,pakRank,loc,pub;
    paku(String name, String wRank, String asiaRank, String pakRank, String loc, String pub){
        this.name=name;
        this.wRank=wRank;
        this.asiaRank=asiaRank;
        this.pakRank=pakRank;
        this.loc=loc;
        this.pub=pub;
    }

    public String toString(){
        return name+" "+wRank+" "+asiaRank+" "+pakRank+" "+loc+" "+pub;
    }
} // end here
