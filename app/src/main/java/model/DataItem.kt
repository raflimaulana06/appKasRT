package model

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("Foto_Warga")
    val foto_warga: Int? = null,

    @field:SerializedName("Nama_Depan")
    val nama_depan: String? = null,

    @field:SerializedName("Nama_Belakang")
    val nama_belakang: String? = null,

    @field:SerializedName("Email")
    val email: String? = null,

    @field:SerializedName("Alamat_Rumah")
    val alamat_rumah: String? = null,

    @field:SerializedName("Jumlah_Iuran_Bulanan_Warga")
    val jumlah_iuran_bulanan_warga: Int? = null,

    @field:SerializedName("Total_Iuran_Individu")
    val total_iuran_indivudu: Int? = null,

    @field:SerializedName("Total_Iuran_Bulanan")
    val total_iuran_bulanan: Int? = null,

    @field:SerializedName("Pengeluran_Iuran")
    val pengeluaran_iuran: Int? = null,

    @field:SerializedName("Pemanfaatan_Iuran")
    val pemanfaatan_iuran: String? = null,

    @field:SerializedName("Kegunaan_Iuran")
    val kegunaan_iuran: Int? = null,

    )
