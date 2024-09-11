/*
 * MIT License
 *
 * Copyright (c) 2024 Financial Checker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.financialchecker.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBalance
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.GpsFixed
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.Report
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ViewComfy
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.financialchecker.presenter.ui.navigation.DrawerHeader
import com.financialchecker.presenter.ui.navigation.MenuItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                NavigationDrawer()
            }
        }
    }

    @Composable
    fun MenuSubTitleItem(text: String) {
        Text(
            text = text.uppercase(),
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 28.dp)
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun NavigationDrawer() {
        //================================================
        val menuItems = listOf(
            MenuItem(
                id = "overview",
                title = "Overview",
                contentDescription = "Go to overview screen",
                icon = Icons.Filled.ViewComfy
            ),
            MenuItem(
                id = "account",
                title = "Account",
                contentDescription = "Go to account screen",
                icon = Icons.Filled.AccountBalance
            ),
            MenuItem(
                id = "transactions",
                title = "Transactions",
                contentDescription = "Get transactions",
                icon = Icons.Filled.Money
            ),
            MenuItem(
                id = "credit_card",
                title = "Credit Card",
                contentDescription = "Get Credit Card",
                icon = Icons.Filled.CreditCard
            ),
            MenuItem(
                id = "budgets",
                title = "Budgets",
                contentDescription = "Get Budget",
                icon = Icons.Filled.Percent
            ),
            MenuItem(
                id = "goals",
                title = "Goals",
                contentDescription = "Get Goals",
                icon = Icons.Filled.GpsFixed
            ),
            MenuItem(
                id = "report",
                title = "Report",
                contentDescription = "Get Report",
                icon = Icons.Filled.Report
            ),
            MenuItem(
                id = "charts",
                title = "Charts",
                contentDescription = "Get Charts",
                icon = Icons.Filled.PieChart
            ),
            MenuItem(
                id = "categories",
                title = "Categories",
                contentDescription = "Get Categories",
                icon = Icons.Filled.Category
            ),
            MenuItem(
                id = "calendar",
                title = "Calendar",
                contentDescription = "Get Calendar",
                icon = Icons.Filled.CalendarMonth
            ),
            MenuItem(
                id = "tools",
                title = "Tools",
                contentDescription = "Get Tools",
                icon = Icons.Filled.Build
            ),
            MenuItem(
                id = "settings",
                title = "Settings",
                contentDescription = "Get Settings",
                icon = Icons.Filled.Settings
            ),
            MenuItem(
                id = "about",
                title = "About",
                contentDescription = "Get About",
                icon = Icons.Filled.Info
            ),
            MenuItem(
                id = "dark_theme",
                title = "Dark Theme",
                contentDescription = "Get Dark Theeme",
                icon = Icons.Filled.DarkMode
            ),
        )
        //================================================

        //Remember Clicked item state
        var selectedItemIndex by rememberSaveable {
            mutableIntStateOf(0)
        }

        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    // NaviDrawer Header
                    Spacer(modifier = Modifier.height(12.dp))
                    NavigationDrawerItem(
                        label = { DrawerHeader() },
                        selected = false,
                        onClick = { },
                    )

                    // NaviDrawer Body
                    Spacer(modifier = Modifier.height(8.dp))
                    menuItems.forEachIndexed { index, item ->
                        NavigationDrawerItem(
                            label = { Text(text = item.title) },
                            selected = index == selectedItemIndex,
                            onClick = {
                                //  navController.navigate(item.route)
                                selectedItemIndex = index
                                scope.launch {
                                    drawerState.close()
                                }
                            },
                            icon = {
                                Icon(
                                    imageVector = if (index == selectedItemIndex) {
                                        item.icon
                                    } else item.icon,
                                    contentDescription = item.title
                                )
                            },
                            modifier = Modifier
                                .padding(NavigationDrawerItemDefaults.ItemPadding)
                        )
                        if (index == 3) {
                            MenuSubTitleItem("Planning")
                        }
                        if (index == 5) {
                            MenuSubTitleItem("Analyze Finances")
                        }
                        if (index == 9) {
                            HorizontalDivider()
                        }
                        if (index == 11) {
                            HorizontalDivider()
                        }
                        if (index == 12) {
                            HorizontalDivider()
                        }
                    }
                }
            },
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Navigation Drawer Example")
                        },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = "Menu"
                                )
                            }
                        }
                    )
                }
            ) {}
        }


    }
}