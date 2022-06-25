package xyz.heydarrn.aplikasikasirsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // kolom input
        val inputNamaBarang=findViewById<EditText>(R.id.edit_text_nama_barang)
        val inputJumlahBeli=findViewById<EditText>(R.id.edit_text_jumlah_barang)
        val inputHargaSatuan=findViewById<EditText>(R.id.edit_text_harga_satuan)
        val inputUang=findViewById<EditText>(R.id.edit_text_uang)

        //tombol untuk menjalankan perhitungan
        val tombolHitungBayar=findViewById<Button>(R.id.button_hitung_pembayaran)

        //label untuk menampilkan hasil perhitungan
        val biayaBarang=findViewById<TextView>(R.id.text_view_biaya)
        val kembalian=findViewById<TextView>(R.id.text_view_kembalian)


        tombolHitungBayar.setOnClickListener {
            val jumlah=inputJumlahBeli.text.toString().toDouble()
            val harga=inputHargaSatuan.text.toString().toDouble()

            val uang: Double = inputUang.text.toString().toDouble()
            val barang: String = inputNamaBarang.text.toString()

            val totalBiaya=jumlah*harga
            val kembali=uang - totalBiaya

            Toast.makeText(this, "Kamu membeli $barang dengan biaya Rp. $totalBiaya", Toast.LENGTH_SHORT).show()
            kembalian.text=getString(R.string.kembalian_template, kembali.toString())
            biayaBarang.text=getString(R.string.total_biaya_template, totalBiaya.toString())
        }

    }
}