package com.example.alphaspace.screens.profileScreen.sections

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.alphaspace.Model.data.ProfileTabs
import com.example.alphaspace.screens.profileScreen.component.sideCards.client.BestClientCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.employee.BestEmployeeCard
import com.example.alphaspace.screens.profileScreen.component.slots.SideCard_Slot
import com.example.alphaspace.screens.profileScreen.component.sideCards.stock.BestSellersCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.BrandsCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.DeliveryCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.ExchangeCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.stock.ExpensiveCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.stock.LostCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.MoneyBackCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.ProductTypeCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.SexCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.TargetTypeCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.home.WorkTimeCard
import com.example.alphaspace.screens.profileScreen.component.sideCards.stock.WorstCard


@Composable
fun sideSection(modifier: Modifier = Modifier , indicator : String) {
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxHeight()
            .padding(start = 26.dp)
    ) {

        item {
            Spacer(modifier = Modifier.height(26.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Work time" ,
                    content = {
                        WorkTimeCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                        )
                    }
                )
            }
            else if(indicator == ProfileTabs.tabs[1])
            {
                SideCard_Slot(
                    title = "Best sellers" ,
                    content = {
                        BestSellersCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(2.dp)
                        )
                    }
                )
            }
            else if(indicator == ProfileTabs.tabs[2])
            {
                SideCard_Slot(
                    title = "Best clients" ,
                    content = {
                        BestClientCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(2.dp)
                        )
                    }
                )
            }
            else if(indicator == ProfileTabs.tabs[3])
            {
                SideCard_Slot(
                    title = "Best employees" ,
                    content = {
                        BestEmployeeCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(2.dp)
                        )
                    }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Delivery" ,
                    content = {
                        DeliveryCard(
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                    }
                )
            }
            else if(indicator == ProfileTabs.tabs[1])
            {
                SideCard_Slot(
                    title = "Lost" ,
                    content = {
                        LostCard(
                            modifier = Modifier.fillMaxWidth(0.8f)
                                .padding(2.dp)
                        )
                    }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Change" ,
                    content = {
                        ExchangeCard(
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                    }
                )
            }
            else if(indicator == ProfileTabs.tabs[1])
            {
                SideCard_Slot(
                    title = "Worst of all" ,
                    content = {
                        WorstCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .padding(2.dp)
                        )
                    }
                )
            }
        }


        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Money back" ,
                    content = {
                        MoneyBackCard(
                            modifier = Modifier.fillMaxWidth(0.8f)
                        )
                    }
                )
            }
            else if(indicator == ProfileTabs.tabs[1])
            {
                SideCard_Slot(
                    title = "The most expensive" ,
                    content = {
                        ExpensiveCard(
                            modifier = Modifier.fillMaxWidth(0.8f)
                                .padding(2.dp)
                        )
                    }
                )
            }
        }


        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Product types" ,
                    content = {
                        ProductTypeCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(80.dp)
                        )
                    }
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Sex" ,
                    content = {
                        SexCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(80.dp)
                        )
                    }
                )
            }
        }


        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Location",
                    content = {
                        Spacer(
                            modifier = Modifier.height(60.dp)
                        )
                    }
                )
            }
        }


        item {
            Spacer(modifier = Modifier.height(18.dp))


            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Target type" ,
                    content = {
                        TargetTypeCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(80.dp)
                        )
                    }
                )
            }
        }


        item {
            Spacer(modifier = Modifier.height(18.dp))

            if (indicator == ProfileTabs.tabs[0]){
                SideCard_Slot(
                    title = "Big brands" ,
                    content = {
                        BrandsCard(
                            modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(80.dp)
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.height(18.dp))

        }




    }
}

@Preview(widthDp = 250 , heightDp = 500)
@Composable
fun sideSection_preview() {
    sideSection(indicator = ProfileTabs.tabs[0])
}