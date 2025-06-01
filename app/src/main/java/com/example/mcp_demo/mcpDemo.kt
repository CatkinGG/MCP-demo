import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mcp_demo.R

@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(44.dp)) // Status Bar
        Header()
        Spacer(Modifier.height(16.dp))
        StatsRow()
        Spacer(Modifier.height(16.dp))
        PillsRow()
        Spacer(Modifier.height(16.dp))
        ChartCard()
        Spacer(Modifier.height(16.dp))
        ListCard()
        Spacer(Modifier.weight(1f))
        TabBar()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Image
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(40.dp)
                .background(Color(0xFFE0E0E0), CircleShape)
        )
        Spacer(Modifier.width(16.dp))
        Text(
            text = "App name",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        IconButton(onClick = { }) {
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Image(painter = painterResource(R.drawable.menu_line1), contentDescription = null)
                Image(painter = painterResource(R.drawable.menu_line2), contentDescription = null)
                Image(painter = painterResource(R.drawable.menu_line3), contentDescription = null)
            }
        }
    }
}

@Composable
fun StatsRow() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        StatCard(title = "Title", value = "$45,678.90", change = "+20% month over month")
        StatCard(title = "Title", value = "2,405", change = "+33% month over month")
        StatCard(title = "MAU (Monthly Active Users)", value = "10,353", change = "-8% month over month")
    }
}

@Composable
fun StatCard(title: String, value: String, change: String) {
    Column(
        modifier = Modifier
            .width(120.dp)
            .background(Color(0xFFF6F6F6), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text(title, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Text(value, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(change, fontSize = 12.sp, color = Color(0xFF828282))
    }
}

@Composable
fun PillsRow() {
    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        Pill(text = "Tab", selected = true)
        Pill(text = "Tab", selected = false)
        Pill(text = "Tab", selected = false)
    }
}

@Composable
fun Pill(text: String, selected: Boolean) {
    Box(
        modifier = Modifier
            .background(
                if (selected) Color.Black else Color(0xFFF6F6F6),
                RoundedCornerShape(20.dp)
            )
            .padding(horizontal = 14.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
fun ChartCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color(0xFFF6F6F6), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("Title", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        // Chart PNG 疊加
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.chart_graph_bg),
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )
            Image(
                painter = painterResource(R.drawable.chart_graph_fg),
                contentDescription = null,
                modifier = Modifier.matchParentSize()
            )
        }
    }
}

@Composable
fun ListCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF6F6F6), RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Text("Title", fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
        Spacer(Modifier.height(8.dp))
        UserCell(name = "Elynn Lee", email = "email@fakedomain.net")
        UserCell(name = "Oscar Dum", email = "email@fakedomain.net")
        UserCell(name = "Carlo Emilion", email = "email@fakedomain.net")
        UserCell(name = "Daniel Jay Park", email = "djpark@gmail.com")
        UserCell(name = "Mark Rojas", email = "rojasmar@skiff.com")
    }
}

@Composable
fun UserCell(name: String, email: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(Color(0xFFF7F7F7), CircleShape)
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Text(name, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Text(email, fontSize = 12.sp, color = Color(0xFF828282))
        }
    }
}

@Composable
fun TabBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(83.dp)
            .background(Color.White),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TabBarItem(selected = true, label = "Home")
        TabBarItem(selected = false, label = "Search")
        TabBarItem(selected = false, label = "Transfer")
        TabBarItem(selected = false, label = "Wallet")
    }
}

@Composable
fun TabBarItem(selected: Boolean, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(if (selected) Color.Black else Color(0xFFE0E0E0), CircleShape)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 12.sp,
            color = if (selected) Color.Black else Color(0xFF828282)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DashboardScreenPreview() {
    DashboardScreen()
}
