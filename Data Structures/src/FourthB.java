import java.util.ArrayList;
import java.util.List;

public class FourthB {
    public static void main(String[] args) {
        int[] musteriler = {6,7,2,1,12,5,3,7,4,2};

        int toplam = 0;

        PQ2 pq = new PQ2(musteriler.length); //PQ2 objesinin oluşturulması

        for(int j : musteriler)  // PQ2 Ye mahalle objesinin eklenmesi
            pq.enque(j);

        for(int i = 0;i<musteriler.length;i++){  // Bilgilerin yazdırılması
            int sure = pq.deque();
            System.out.println((i+1)+". Müsterinin Süresi: "+ sure*3);
            System.out.println();
            toplam += sure*3;
        }

        System.out.println("Bu kasa için geçen ortalam süre: "+ toplam/musteriler.length);

    }
}

class PQ2{ // PQ2 objesinin oluşturulmaı

    List<Integer> kuyrukDizi;  // Tamsayıların tutulması için Listin oluşturulması
    int boyut;
    int bas, son;
    int elemanSayisi;

    PQ2(int s) //PQ2 constructor
    {
        kuyrukDizi = new ArrayList<>(s);
        bas = 0; son = -1; elemanSayisi = 0; boyut = s;
    }

    void enque(int j) // PQ2 için ekleme metodu
    { if(son == boyut-1)
        son = -1;
        son++;
        kuyrukDizi.add(j);
        elemanSayisi++;
    }


    public int deque() // PQ2 için en süre harcanan müşteriye göre elemanların çıkarılması için metod
    {
        int tmp = 0;
        int tmp2 = 0;

        for(int i = 0;i< kuyrukDizi.size();i++){
            if(tmp2< kuyrukDizi.get(i)){
                tmp2 = kuyrukDizi.get(i);
                tmp = i;
            }
        }
        kuyrukDizi.remove(tmp);
        return tmp2;
    }

    public boolean bosMu()
    {
        return (elemanSayisi==0);
    }
}

