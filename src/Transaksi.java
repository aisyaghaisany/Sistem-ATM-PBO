
public class Transaksi {

    public void cekSaldo(Rekening rekening) {
        System.out.println("Saldo Anda: Rp" + rekening.getSaldo());
    }

    public void tarikTunai(Rekening rekening, double jumlah) {

        if (jumlah <= 0) {
            System.out.println("Jumlah penarikan tidak valid.");

        } else if (jumlah > rekening.getSaldo()) {
            System.out.println("Saldo tidak mencukupi.");

        } else {
            rekening.tarikSaldo(jumlah);

            System.out.println("Penarikan berhasil.");
            System.out.println("Sisa saldo: Rp" + rekening.getSaldo());
        }
    }

    public void setorTunai(Rekening rekening, double jumlah) {

        if (jumlah <= 0) {
            System.out.println("Jumlah setoran tidak valid.");

        } else {
            rekening.tambahSaldo(jumlah);

            System.out.println("Setor tunai berhasil.");
            System.out.println("Saldo sekarang: Rp" + rekening.getSaldo());
        }
    }

    public void transfer(Rekening asal, Rekening tujuan, double jumlah) {

        if (jumlah <= 0) {
            System.out.println("Jumlah transfer tidak valid.");

        } else if (jumlah > asal.getSaldo()) {
            System.out.println("Saldo tidak mencukupi.");

        } else {
            asal.tarikSaldo(jumlah);
            tujuan.tambahSaldo(jumlah);

            System.out.println("Transfer berhasil!");
            System.out.println("Jumlah transfer: Rp" + jumlah);
            System.out.println("Sisa saldo: Rp" + asal.getSaldo());
        }
    }
}
