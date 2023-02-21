import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Third {
    public static void main(String[] args) {

        String[] mahalleAdlari = {"Özkanlar","Evka 3","Atatürk","Erzene","Kazımdirik","Mevlana","Doğanlar","Ergene"};

        int[] siparisler = {5,2,7,2,7,3,0,1};

        int s = siparisler.length;

        PQ mahalleler = new PQ(s);  // PQ objesinin oluşturulması

        for(int i = 0;i<8;i++){  // PQ'ya Mahalle objelerinin eklenmesi
            mahalleler.enque(new Mahalle(siparisler[i],mahalleAdlari[i]));
        }

        while(!mahalleler.bosMu()){   // Bilgilerin yazdırılması
            Mahalle mahalle = mahalleler.deque();
            if (mahalle==null)
                break;
            System.out.println("Mahalle Adı: "+mahalle.mahalleAdi);
            System.out.println("Teslimat Bilgileri: ");
            for(int i = 0;i<mahalle.teslimatlar.size();i++){
                System.out.println(mahalle.teslimatlar.get(i).yemek+" "+mahalle.teslimatlar.get(i).adet);
            }
            System.out.println();
        }
    }
}

class PQ{  // PQ sınınfının oluşturulması

    List<Mahalle> kuyrukDizi;
    int boyut;
    int bas, son;
    int elemanSayisi;

    PQ(int s)
    {
        kuyrukDizi = new ArrayList<>(s);
        bas = 0; son = -1; elemanSayisi = 0; boyut = s;
    }

      void enque(Mahalle j) // PQ sınıfına Mahalle objelerinin eklenmesi için metod
    { if(son == boyut-1)
        son = -1;
        son++;
        kuyrukDizi.add(j);
        elemanSayisi++;
    }


    public Mahalle deque()  // PQ sınıfından Mahalle objelerinin çıkarılması için metod ( en fazla teslimat sayısına göre
            // çıkarma işlemi yapılmaktadır
    {
        Mahalle temp = null;
        int temp1 = 0;

        for(int i = 0;i<elemanSayisi;i++){
            if(temp1 < kuyrukDizi.get(i).toplamTeslimat){
                temp1 = kuyrukDizi.get(i).toplamTeslimat;
                temp = kuyrukDizi.get(i);}
        }
        kuyrukDizi.remove(temp);
        elemanSayisi--;
        return temp;
    }

    public boolean bosMu()
    {
        return (elemanSayisi==0);
    }
}
