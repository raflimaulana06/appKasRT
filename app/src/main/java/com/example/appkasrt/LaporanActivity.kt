package com.example.appkasrt

import PemanfaatanAdapter
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import model.ResponseUser
import network.ApiConfig
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class LaporanActivity : AppCompatActivity() {
    private lateinit var rv_laporan: RecyclerView
    private lateinit var adapter: PemanfaatanAdapter
    private lateinit var jumlahIuranBulananTextView: TextView
    private lateinit var totalIuranTextView: TextView
    private lateinit var pengeluaranTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_laporan)


        rv_laporan = findViewById(R.id.rv_laporan)
        jumlahIuranBulananTextView = findViewById(R.id.jumlahIuranBulananTextView)
        totalIuranTextView = findViewById(R.id.totalIuranTextView)
        pengeluaranTextView = findViewById(R.id.pengeluaranTextView)

        adapter = PemanfaatanAdapter(mutableListOf())

        rv_laporan.layoutManager = LinearLayoutManager(this)

        rv_laporan.adapter = adapter


        getPemanfaatann()

    }

    private fun getPemanfaatann(){
        val apiService = ApiConfig.getApiService()
        val client = apiService.getPemanfaatan()


            client.enqueue (object : Callback<ResponseUser> {
                override fun onResponse(call: Call<ResponseUser>,response: Response<ResponseUser>) {
                    if (response.isSuccessful) {
                        val dataArray = response.body()?.data
                        if (dataArray != null) {
                            var totalIuranBulanan = 0
                            var totalPengeluaran = 0

                            for (dataitem in dataArray) {
                                totalIuranBulanan += dataitem.total_iuran_bulanan!!
                                totalPengeluaran += dataitem.pengeluaran_iuran!!
                            }

                            val rekapIuran = totalIuranBulanan - totalPengeluaran

                            jumlahIuranBulananTextView.text =
                                "1. Jumlah Iuran Bulanan: $totalIuranBulanan"
                            pengeluaranTextView.text = "3. Total Pengeluaran: $totalPengeluaran"
                            totalIuranTextView.text = "4. Rekap Total Iuran : $rekapIuran"

                            adapter.setPemanfaatan(dataArray)
                        } else { Toast.makeText(this@LaporanActivity, "Data not Found", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(
                            this@LaporanActivity, "Failed to retrieve data", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseUser>, t: Throwable) {
                    Toast.makeText(
                        this@LaporanActivity, "ERROR: ${t.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    t.printStackTrace()
                }
            })
        }
    }







