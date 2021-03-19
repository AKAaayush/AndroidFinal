package com.aayush.resturant_management_system.RMS.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aayush.resturant_management_system.R
import com.aayush.resturant_management_system.RMS.adapter.FoodItemAdapter
import com.aayush.resturant_management_system.RMS.adapter.FoodMenuAdapter
import com.aayush.resturant_management_system.RMS.database.FoodItemDatabase
import com.aayush.resturant_management_system.RMS.database.FoodMenuDatabase
import com.aayush.resturant_management_system.RMS.entity.FoodItem
import com.aayush.resturant_management_system.RMS.entity.FoodMenu
import com.aayush.resturant_management_system.RMS.repository.FoodItemRepository
import com.aayush.resturant_management_system.RMS.repository.FoodMenuRepository
import com.synnapps.carouselview.CarouselView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class HomeFragment : Fragment() {
//    private lateinit var menurecycler: RecyclerView
    private lateinit var fooditemrecycler: RecyclerView
    private  lateinit var  carouselView : CarouselView

    //Carousel
    var sampleImage = intArrayOf(
            R.drawable.logo,
            R.drawable.backg,
            R.drawable.logo
    )
    var title = arrayOf(
            "food",
            "ffof",
            "MOMo"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)
        carouselView = view.findViewById(R.id.carouselView)
        fooditemrecycler=view.findViewById(R.id.fooditemrecycler)


        //carouselView
        carouselView.pageCount = title.size
        carouselView.setImageClickListener { position ->

            Toast.makeText(context, title[position] , Toast.LENGTH_SHORT).show()
        }

        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(sampleImage[position])

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
                if(response.success==true){
                    withContext(Dispatchers.Main){
                        println(response)
                        val fooditemlist = response.data
                        FoodItemDatabase.getInstance(requireContext()).getFoodItemDAO().deleteFoodItem()
                        FoodItemDatabase.getInstance(requireContext()).getFoodItemDAO().insertfoodItem(response.data)
                        Toast.makeText(context, "$fooditemlist", Toast.LENGTH_SHORT).show()
                        val adapter = FoodItemAdapter(
                                fooditemlist as ArrayList<FoodItem>,
                                requireContext()
                        )
                        fooditemrecycler.layoutManager = LinearLayoutManager(context)
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
}
