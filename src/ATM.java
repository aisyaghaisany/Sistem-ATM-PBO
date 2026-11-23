
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Nasabah nasabah1 = new Nasabah("Aisya", "11111");
        Rekening rekening1 = new Rekening(1000000, "1234");

        Nasabah nasabah2 = new Nasabah("Budi", "22222");
        Rekening rekening2 = new Rekening(2000000, "5678");

        Nasabah nasabah3 = new Nasabah("Citra", "33333");
        Rekening rekening3 = new Rekening(1500000, "1111");

        Transaksi transaksi = new Transaksi();

        System.out.println("================================");
        System.out.println("          ATM SEDERHANA");
        System.out.println("================================");

        System.out.print("Masukkan nomor rekening: ");
        String nomorRekening = input.nextLine();

        System.out.print("Masukkan PIN: ");
        String pin = input.nextLine();

        Nasabah nasabah = null;
        Rekening rekening = null;

        if (nomorRekening.equals(nasabah1.getNomorRekening())
                && rekening1.cekPin(pin)) {

            nasabah = nasabah1;
            rekening = rekening1;

        } else if (nomorRekening.equals(nasabah2.getNomorRekening())
                && rekening2.cekPin(pin)) {

            nasabah = nasabah2;
            rekening = rekening2;

        } else if (nomorRekening.equals(nasabah3.getNomorRekening())
                && rekening3.cekPin(pin)) {

            nasabah = nasabah3;
            rekening = rekening3;

        } else {

            System.out.println("Nomor rekening atau PIN salah.");
            System.out.println("Program selesai.");
            input.close();
            return;
        }

        System.out.println("\nLogin berhasil!");
        System.out.println("Selamat datang, " + nasabah.getNama());

        int pilihan;

        do {

            System.out.println("\n================================");
            System.out.println("             MENU ATM");
            System.out.println("================================");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Transfer");
            System.out.println("5. Ganti PIN");
            System.out.println("6. Keluar");
            System.out.println("================================");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    transaksi.cekSaldo(rekening);
                    break;

                case 2:
                    System.out.print("Masukkan jumlah tarik tunai: Rp");
                    double tarik = input.nextDouble();

                    transaksi.tarikTunai(rekening, tarik);
                    break;

                case 3:
                    System.out.print("Masukkan jumlah setor tunai: Rp");
                    double setor = input.nextDouble();

                    transaksi.setorTunai(rekening, setor);
                    break;

                case 4:
                    input.nextLine();

                    System.out.print("Masukkan nomor rekening tujuan: ");
                    String nomorTujuan = input.nextLine();

                    Rekening tujuan = null;

                    if (nomorTujuan.equals(nasabah1.getNomorRekening())) {
                        tujuan = rekening1;
                    } else if (nomorTujuan.equals(nasabah2.getNomorRekening())) {
                        tujuan = rekening2;
                    } else if (nomorTujuan.equals(nasabah3.getNomorRekening())) {
                        tujuan = rekening3;
                    }

                    if (tujuan == null) {
                        System.out.println("Rekening tujuan tidak ditemukan.");

                    } else if (tujuan == rekening) {
                        System.out.println("Tidak bisa transfer ke rekening sendiri.");

                    } else {
                        System.out.print("Masukkan jumlah transfer: Rp");
                        double jumlah = input.nextDouble();

                        transaksi.transfer(rekening, tujuan, jumlah);
                    }
                    break;

                case 5:
                    input.nextLine();

                    System.out.print("Masukkan PIN baru: ");
                    String pinBaru = input.nextLine();

                    if (pinBaru.length() != 4) {
                        System.out.println("PIN harus terdiri dari 4 angka.");
                    } else {
                        rekening.gantiPin(pinBaru);
                        System.out.println("PIN berhasil diganti.");
                    }
                    break;

                case 6:
                    System.out.println("Terima kasih telah menggunakan ATM.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 6);

        input.close();
    }
}
