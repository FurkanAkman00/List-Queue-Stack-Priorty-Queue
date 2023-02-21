import java.util.Stack;

public class SecondA {
    public static void main(String[] args) {

        String[] mahalleAdlari = {"Özkanlar","Evka 3","Atatürk","Erzene","Kazımdirik","Mevlana","Doğanlar","Ergene"};

        int[] siparisler = {5,2,7,2,7,3,0,1};

        Yigit mahalleler = new Yigit(100); // Mahalle objeleri için stackin oluşturulması

        for(int i = 0;i<8;i++){ // Stackin içine mahalle objelerinin yerleştirilmesi
            mahalleler.push(new Mahalle(siparisler[i],mahalleAdlari[i]));
        }

        while(!mahalleler.isEmpty()){  // Bilgileriin yazdırılması
            Mahalle mahalle = mahalleler.pop();
            System.out.println("Mahalle Adı: "+mahalle.mahalleAdi);
            System.out.println("Teslimat Bilgileri: ");
            for(int i = 0;i<mahalle.teslimatlar.size();i++){
                System.out.println(mahalle.teslimatlar.get(i).yemek+" "+mahalle.teslimatlar.get(i).adet);
            }
            System.out.println();
        }
    }
}

class Yigit {
    private int maxSize;
    private Mahalle[] stackArray;
    private int top;
    public Yigit(int max) {
        maxSize = max;
        stackArray = new Mahalle[maxSize];
        top = -1;
    }

    public void push(Mahalle j)
    { stackArray[++top] = j; }
    public Mahalle pop()
    { return stackArray[top--]; }
    public boolean isEmpty()
    { return top== -1; }
}
