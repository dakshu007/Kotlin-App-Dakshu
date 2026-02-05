package com.dakshesh.portfolio.data.models

import androidx.annotation.DrawableRes

data class PortfolioProject(
    val id: Int,
    val name: String,
    val description: String,
    val url: String,
    val role: String,
    val technologies: List<String>,
    val features: List<String>,
    @DrawableRes val imageRes: Int = 0
)

data class Skill(
    val name: String,
    val level: Int, // 1-100
    val icon: String
)

data class Experience(
    val title: String,
    val duration: String,
    val description: String,
    val company: String = "Freelance"
)

data class Testimonial(
    val name: String,
    val role: String,
    val content: String,
    val company: String
)