import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab1.labthuyettrinh.navigationSimple.ColorScreen
import com.example.lab1.labthuyettrinh.navigationSimple.HomeScreen

@Composable
fun MyAppNavigation() {
    // 1. Tạo một NavController để quản lý việc điều hướng
    val navController = rememberNavController()

    // 2. Thiết lập NavHost, là nơi chứa tất cả các màn hình
    NavHost(navController = navController, startDestination = "home") {

        // 3. Định nghĩa màn hình chính (home)
        composable("home") {
            // Khi route là "home", hiển thị HomeScreen và truyền navController vào
            HomeScreen(navController = navController)
        }

        // 4. Định nghĩa màn hình chi tiết màu sắc (detail)
        // Route này có 2 tham số: colorName và colorHex
        composable(
            route = "detail/{colorName}/{colorHex}",
            arguments = listOf(
                navArgument("colorName") { type = NavType.StringType },
                navArgument("colorHex") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            // Lấy các tham số từ route
            val name = backStackEntry.arguments?.getString("colorName") ?: ""
            val hex = backStackEntry.arguments?.getString("colorHex") ?: "FFFFFFFF"

            // Chuyển đổi chuỗi hex thành giá trị màu (Long)
            // Phải thêm "FF" vào đầu để có kênh alpha (độ trong suốt)
            val colorValue = ("FF" + hex).toLong(16)

            // Hiển thị màn hình ColorScreen với dữ liệu đã lấy được
            ColorScreen(navController = navController, colorName = name, colorValue = colorValue)
        }
    }
}