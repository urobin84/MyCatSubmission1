package com.mqr.mycatsubmission1

object CatData{
    private val catId = arrayOf("2012794", "2012795", "2012796", "2017770", "2018685", "2018686", "2018687", "2018688", "2018689", "2018690", "2025344", "2025345", "2025347")
    private val catName = arrayOf("Abyssinian", "2012795", "2012796", "2017770", "2018685", "2018686", "2018687", "2018688", "2018689", "2018690", "2025344", "2025345", "2025347")
    private val catDescription = arrayOf("Binatang bertubuh mini ini mirip dengan cougar berukuran kecil. Jenisnya yang mempunyai corak kemerah-merahan memiliki bulu yang mempesona.  Jika kamu mencari kucing yang terlihat mewah, kamu dapat mempertimbangkan jenis kucing abyssianian ini yang termasuk dalam aristocrats. Salah satu jenis kucing tertua yang dipercaya sebagian keturunan dari kucing suci di Mesir (hal ini berdasarkan lukisan dan patung Mesir). Kini ras kucing Abyssinian dipelihara secara berhati – hati untuk warna, pola dan jenisnya. Salah satu keistimewaan kucing ini adalah matanya – bentuknya yang seperti almond memikat semua orang yang melihatnya. Mereka bertingkah seperti harimau kumbang ketika bermain dan melakukan kegiatan.  Tidak hanya terlihat mewah, mereka juga dapat menari dengan lemah gemulai. Sangat penyayang dan ramah adalah nalurinya, selama mereka dirawat dengan baik mereka akan menjadi hewan peliharaan yang luar biasa. Mereka bukan binatang yang senang bicara, tapi mereka senang memanjat, jadi waspadalah dengan nalurinya yang satu ini. Mereka juga tidak senang berada di dalam kandang jadi hindari hal ini.\n" +
            "Karena mereka memiliki naluri untuk bermain di luar rumah maka akan lebih baik anda memberikan tanda pengenal pada kucing anda untuk mempermudah melacak kucing jika kucing anda hilang.", "2012795", "2012796", "2017770", "2018685", "2018686", "2018687", "2018688", "2018689", "2018690", "2025344", "2025345", "2025347")
    private val createdAt = arrayOf("2020-01-25T16:05:08.000Z", "2020-01-25T16:05:15.000Z", "2020-01-25T16:05:17.000Z", "2020-04-25T07:00:26.000Z", "2020-05-05T06:05:15.000Z", "2020-05-05T06:05:18.000Z", "2020-05-05T06:05:20.000Z", "2020-05-05T06:05:23.000Z", "2020-05-05T06:05:25.000Z", "2020-05-05T06:05:28.000Z", "2020-07-29T15:05:44.000Z", "2020-07-29T15:05:45.000Z", "2020-07-29T15:06:10.000Z")
    private val image = arrayOf( R.drawable.cat1 , R.drawable.cat2, R.drawable.cat3, R.drawable.cat4, R.drawable.cat5, R.drawable.cat6, R.drawable.cat7, R.drawable.cat8, R.drawable.cat9, R.drawable.cat10, R.drawable.cat11, R.drawable.cat12, R.drawable.cat13)

    val listData: ArrayList<Cat>
        get() {
            val list = arrayListOf<Cat>()
            for (position in catId.indices) {
                val cat = Cat()
                cat.id = catId[position]
                cat.created_at = createdAt[position]
                cat.image = image[position]

                list.add(cat)
            }
            return list
        }
}