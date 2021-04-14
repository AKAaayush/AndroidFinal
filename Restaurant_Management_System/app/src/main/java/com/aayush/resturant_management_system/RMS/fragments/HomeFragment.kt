package com.aayush.resturant_management_system.RMS.fragments

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.`object`.LoginActivity
import com.aayush.resturant_management_system.RMS.adapter.FoodItemAdapter
import com.aayush.resturant_management_system.RMS.adapter.FoodMenuAdapter
//import com.aayush.resturant_management_system.RMS.adapter.HomeAdapter
import com.aayush.resturant_management_system.RMS.database.Db
import com.aayush.resturant_management_system.RMS.database.FoodItemDatabase
import com.aayush.resturant_management_system.RMS.database.FoodMenuDatabase
import com.aayush.resturant_management_system.RMS.entity.FoodItem
import com.aayush.resturant_management_system.RMS.entity.FoodMenu
import com.aayush.resturant_management_system.RMS.repository.FoodItemRepository
import com.aayush.resturant_management_system.RMS.repository.FoodMenuRepository
import com.synnapps.carouselview.CarouselView
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main


class HomeFragment : Fragment() {
//    private lateinit var menurecycler: RecyclerView
    private lateinit var fooditemrecycler: RecyclerView
//     private lateinit var favRecycle : RecyclerView
    private  lateinit var  carouselView : CarouselView
    private  val  fragment= AddToCartFragment()
    private lateinit var  cartbtn : ImageView

    //Carousel
    var sampleImage = intArrayOf(
            R.drawable.food,
            R.drawable.food1,
            R.drawable.food2
    )
    var title = arrayOf(
            "Food",
            "Food",
            "Food"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        carouselView = view.findViewById(R.id.carouselView)
        fooditemrecycler=view.findViewById(R.id.fooditemrecycler)
            cartbtn=view.findViewById(R.id.cartbtn)
//        favRecycle=view.findViewById(R.id.favRecycle)


        //carouselView
        carouselView.pageCount = title.size
        carouselView.setImageClickListener { position ->

            Toast.makeText(context, title[position] , Toast.LENGTH_SHORT).show()
        }

        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(sampleImage[position])

        }

        cartbtn.setOnClickListener {
//            loadFragment(fragment)

            val builder = AlertDialog.Builder(requireContext())
            builder.setMessage("DO you Want to logout")
            builder.setIcon(android.R.drawable.ic_dialog_alert)
            builder.setPositiveButton("yes"){dialogInterface, which->
                val sharePref = requireActivity().getSharedPreferences("MyPref",AppCompatActivity.MODE_PRIVATE )
                val editor = sharePref.edit()
                editor.remove("email")
                editor.remove("password")
                editor.remove("_id")
                editor.remove("name")
                    .apply()

                CoroutineScope(Dispatchers.IO).launch{
                    Db.getInstance(requireContext()).getUserDao().logout()
                    withContext(Main){
                        startActivity(Intent(context, LoginActivity::class.java))
                    }
                }
            }
            builder.setNegativeButton("No"){
                dialogInterface, which ->
            }
            builder.show()
        }





//
        getFoodData()

        return view;
    }

    fun getFoodData(){
        try{
            CoroutineScope(Dispatchers.IO).launch {
                val foodItemRepository = FoodItemRepository()
                val response = foodItemRepository.getFoodItemApiData()
                println(response)
                if(response.success==true){
                    withContext(Dispatchers.Main){
                        println(response)
                        val fooditemlist = response.data
                        FoodItemDatabase.getInstance(requireContext()).getFoodItemDAO().deleteFoodItem()
                        FoodItemDatabase.getInstance(requireContext()).getFoodItemDAO().insertfoodItem(response.data)
//                        Toast.makeText(context, "$fooditemlist", Toast.LENGTH_SHORT).show()
                        val adapter = FoodItemAdapter(
                                fooditemlist as ArrayList<FoodItem>,
                                requireContext()
                        )
//                        val alllist= Db.getInstance(requireContext()).getFoodItemDAO().getproduct()
//                        val adpater= context?.let { HomeAdapter(alllist as ArrayList<FoodItem>, it) }
                        fooditemrecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                        fooditemrecycler.adapter = adapter
                    }
                }
            }
        }catch (ex: Exception){
            Toast.makeText(
                    context,
                    "Error : ${ex.toString()}", Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun loadFragment(fragment: Fragment){
        val trans=fragmentManager?.beginTransaction()
        trans?.replace(R.id.containerViewPager,fragment)
        trans?.disallowAddToBackStack()
        trans?.commit()
    }



//     fun loadvlaue(){
//        CoroutineScope(Dispatchers.IO).launch{
//            val repositrory=FoodItemRepository()
//            val response=repositrory.getFoodItemApiData()
//            if(response.success==true){
//                val list=response.data
//                Db.getInstance(requireContext()).getFoodItemDAO().dropTable()
//                Db.getInstance(requireContext()).getFoodItemDAO().AddProdcut(list)
//                val alllist=FoodItemDatabase.getInstance(requireContext()).getFoodItemDAO().getproduct()
//                withContext(Dispatchers.Main){
//                    val adpater= context?.let { HomeAdapter(alllist as ArrayList<FoodItem>, it) }
//                    fooditemrecycler.setHasFixedSize(true);
//                    fooditemrecycler.layoutManager =LinearLayoutManager(activity)
//                    fooditemrecycler.adapter=adpater;
//                }
//            }
//        }
//    }
}
