import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class First {
    public static void main(String[] args) {
        // Mahalle isimleri için array
        String[] mahalleAdlari = {"Özkanlar","Evka 3","Atatürk","Erzene","Kazımdirik","Mevlana","Doğanlar","Ergene"};

        // Siparişler için array
        int[] siparisler = {5,2,7,2,7,3,0,1};
        // Toplam teslimat sayısı için değişken
        int toplamTeslimat = 0;

        for (int i = 0;i<siparisler.length;i++){ // Toplam teslimat sayısının hesaplanması
            toplamTeslimat += siparisler[i];
        }

        List<Mahalle>first; // List objesinin oluşturulması

        first = method1(mahalleAdlari,siparisler); //

        for(int i = 0; i<first.size();i++){  // Mahalle adlarının ve teslimatların yazdırılması
            System.out.println();
            System.out.println("Mahalle adı: "+first.get(i).mahalleAdi);
            for(int j = 0;j<first.get(i).teslimatlar.size();j++){
                System.out.println("Yemekler ve sipariş adedi: "+first.get(i).teslimatlar.get(j).yemek+" "+
                        first.get(i).teslimatlar.get(j).adet);
            }
        }
        System.out.println();
        System.out.println("Toplam liste sayısı: "+mahalleAdlari.length);
        System.out.println("Toplam teslimat sayısı: "+toplamTeslimat);
    }

    public static List method1(String[] mahalleAdlari, int[] siparisler){

        List<Mahalle> mahalleler = new ArrayList<>();

        for(int i = 0;i<mahalleAdlari.length;i++){ // List objesinin içine Mahalle objesinin yerleştirilmesi
            mahalleler.add(new Mahalle(siparisler[i],mahalleAdlari[i]));
        }

        return mahalleler; // Mahallelerden oluşan ArrayList'in döndürülmesi
    }
}

class Mahalle{  // Mahalle sınıfının oluşturulması

    List<Teslimat> teslimatlar = new ArrayList<>();  // Teslimatları depolamak için listin oluşturulması

    int toplamTeslimat = 0;  // toplam teslimat sayısı için değişken

    String mahalleAdi;  // Mahalle adı için değişken

    Random rn = new Random();

    ArrayList<String> yemekler = new ArrayList<>(Arrays.asList("Börek","Kızartma","Türlü","Dolma","Pasta"
    ,"Poğaça","Pilav","Pizza","Makarna","Dürüm","İskender","Kebap")); // yemekler için arraylist

    Mahalle(int teslimatAdet,String mahalleAdi){ // Mahalle objesinin constructurı

        int n = 0;
        this.mahalleAdi = mahalleAdi;

        for(int i = 0; i<teslimatAdet;i++){
            int index = rn.nextInt(0,(12-(n+1))); n++; int adet = rn.nextInt(1,50);
            Teslimat teslimat = new Teslimat(yemekler.get(index),adet); // teslimat objesinin oluşturulması
            toplamTeslimat += adet;
            teslimatlar.add(teslimat); // teslimat objesinin teslimatlar listine eklenmesi
            yemekler.remove(index);
        }
    }
}

class Teslimat { // Teslimat sınıfı

    String yemek;
    int adet;

    Teslimat(String newYemek, int newAdet) {
        this.yemek = newYemek;
        this.adet = newAdet;
    }
}
