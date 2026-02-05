package com.dakshesh.portfolio.ui.screens

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.dakshesh.portfolio.data.PortfolioRepository
import kotlinx.coroutines.delay

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    var animatedValue by remember { mutableStateOf(0f) }
    
    LaunchedEffect(Unit) {
        while (true) {
            animatedValue = 0f
            repeat(100) {
                animatedValue += 0.01f
                delay(20)
            }
        }
    }
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
                        MaterialTheme.colorScheme.background
                    )
                )
            )
    ) {
        // Animated Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Animated Profile Image
                AnimatedContent(
                    targetState = animatedValue,
                    transitionSpec = {
                        fadeIn() + slideInVertically() with fadeOut() + slideOutVertically()
                    }
                ) { _ ->
                    Box(
                        modifier = Modifier
                            .size(120.dp)
                            .shadow(16.dp, CircleShape)
                            .clip(CircleShape)
                            .background(Color.White)
                    ) {
                        AsyncImage(
                            model = "https://ui-avatars.com/api/?name=Dakshesh&background=7C4DFF&color=fff&size=256",
                            contentDescription = "Dakshesh",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
                // Animated Name
                AnimatedVisibility(
                    visible = animatedValue > 0.3f,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    Text(
                        text = "Dakshesh",
                        style = MaterialTheme.typography.headlineLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
                
                AnimatedVisibility(
                    visible = animatedValue > 0.5f,
                    enter = fadeIn() + slideInVertically(),
                    exit = fadeOut() + slideOutVertically()
                ) {
                    Text(
                        text = "WordPress Developer & Designer",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    )
                }
            }
        }
        
        // Stats Cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .offset(y = (-40).dp)
        ) {
            AnimatedVisibility(
                visible = animatedValue > 0.6f,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                StatCard(
                    title = "1.5+ Years",
                    subtitle = "Experience",
                    icon = Icons.Default.Timer,
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            AnimatedVisibility(
                visible = animatedValue > 0.7f,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                StatCard(
                    title = "50+",
                    subtitle = "Projects",
                    icon = Icons.Default.Work,
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            AnimatedVisibility(
                visible = animatedValue > 0.8f,
                enter = fadeIn() + slideInHorizontally(),
                exit = fadeOut() + slideOutHorizontally()
            ) {
                StatCard(
                    title = "100%",
                    subtitle = "Satisfaction",
                    icon = Icons.Default.Star,
                    modifier = Modifier.weight(1f)
                )
            }
        }
        
        // Quick Navigation Cards
        val navItems = listOf(
            "Projects" to Icons.Default.Work to "projects",
            "Skills" to Icons.Default.Code to "skills",
            "About" to Icons.Default.Person to "about",
            "Contact" to Icons.Default.Email to "contact"
        )
        
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(navItems.size) { index ->
                val (titleIconPair, destination) = navItems[index]
                val (title, icon) = titleIconPair
                
                AnimatedVisibility(
                    visible = animatedValue > (0.4f + index * 0.1f),
                    enter = fadeIn() + slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth * (index + 1) }),
                    exit = fadeOut() + slideOutHorizontally()
                ) {
                    NavigationCard(
                        title = title,
                        icon = icon,
                        onClick = { navController.navigate(destination) }
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(32.dp))
        
        // Featured Projects Preview
        AnimatedVisibility(
            visible = animatedValue > 0.9f,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Featured Work",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                PortfolioRepository.getProjects().take(2).forEach { project ->
                    ProjectPreviewCard(
                        project = project,
                        onClick = { navController.navigate("projects") }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
}

@Composable
fun StatCard(
    title: String,
    subtitle: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )
        }
    }
}

@Composable
fun NavigationCard(
    title: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.width(120.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(32.dp)
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = title,
                style = MaterialTheme.typography.labelLarge,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }
    }
}

@Composable
fun ProjectPreviewCard(
    project: com.dakshesh.portfolio.data.models.PortfolioProject,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = project.name,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                maxLines = 2
            )
            
            Spacer(modifier = Modifier.height(12.dp))
            
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "View Details →",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
