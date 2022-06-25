package xyz.heydarrn.aplikasikasirsederhana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import xyz.heydarrn.aplikasikasirsederhana.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingMainActivity: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        bindingMainActivity= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingMainActivity.root)

        //dengan findViewById
        // kolom input
//        val inputNamaBarang=findViewById<EditText>(R.id.edit_text_nama_barang)
//        val inputJumlahBeli=findViewById<EditText>(R.id.edit_text_jumlah_barang)
//        val inputHargaSatuan=findViewById<EditText>(R.id.edit_text_harga_satuan)
//        val inputUang=findViewById<EditText>(R.id.edit_text_uang)
//
//        //tombol untuk menjalankan perhitungan
//        val tombolHitungBayar=findViewById<Button>(R.id.button_hitung_pembayaran)
//
//        //label untuk menampilkan hasil perhitungan
//        val biayaBarang=findViewById<TextView>(R.id.text_view_biaya)
//        val kembalian=findViewById<TextView>(R.id.text_view_kembalian)
//
//
//        tombolHitungBayar.setOnClickListener {
//            val jumlah=inputJumlahBeli.text.toString().toDouble()
//            val harga=inputHargaSatuan.text.toString().toDouble()
//
//            val uang: Double = inputUang.text.toString().toDouble()
//            val barang: String = inputNamaBarang.text.toString()
//
//            val totalBiaya=jumlah*harga
//            val kembali=uang - totalBiaya
//
//            Toast.makeText(this, "Kamu membeli $barang dengan biaya Rp. $totalBiaya", Toast.LENGTH_SHORT).show()
//            kembalian.text=getString(R.string.kembalian_template, kembali.toString())
//            biayaBarang.text=getString(R.string.total_biaya_template, totalBiaya.toString())
//        }

        //dengan viewBinding
        bindingMainActivity.apply {
            buttonHitungPembayaran.setOnClickListener {
                val namaBarang=editTextNamaBarang.text.toString()
                val jumlahBarang=editTextJumlahBarang.text.toString().toInt()
                val hargaBarang=editTextHargaSatuan.text.toString().toDouble()
                val uang=editTextUang.text.toString().toDouble()

                val hitungTotal=jumlahBarang * hargaBarang
                val hitungKembalian=uang-hitungTotal

                textViewBiaya.text=getString(R.string.total_biaya_template, hitungTotal.toString())
                textViewKembalian.text=getString(R.string.kembalian_template, hitungKembalian.toString())
                Toast.makeText(this@MainActivity, "Kamu membeli $namaBarang. Kembalinya Rp. $hitungKembalian", Toast.LENGTH_LONG).show()

            }

        }


    }
}