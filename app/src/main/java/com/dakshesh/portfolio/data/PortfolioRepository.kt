package com.dakshesh.portfolio.data

import com.dakshesh.portfolio.data.models.*

object PortfolioRepository {
    fun getAboutMe(): String {
        return "With 1.5 years of dedicated experience in WordPress development and design, " +
               "I specialize in creating stunning, high-performance websites and plugins. " +
               "My expertise includes custom theme development, plugin customization, " +
               "and creating seamless e-commerce solutions. I'm passionate about " +
               "transforming ideas into digital reality with clean code and beautiful designs."
    }
    
    fun getProjects(): List<PortfolioProject> {
        return listOf(
            PortfolioProject(
                id = 1,
                name = "Retainful",
                description = "Next generation email marketing automation platform for WooCommerce",
                url = "https://retainful.com/",
                role = "WordPress Developer & Designer",
                technologies = listOf("WooCommerce", "PHP", "React", "MySQL", "REST API"),
                features = listOf(
                    "Automated email workflows",
                    "Cart abandonment recovery",
                    "Customer segmentation",
                    "Advanced analytics dashboard"
                )
            ),
            PortfolioProject(
                id = 2,
                name = "Flycart",
                description = "Smart WooCommerce cart abandonment solution with AI-powered recovery",
                url = "https://www.flycart.org/",
                role = "Frontend Developer & UI Designer",
                technologies = listOf("JavaScript", "CSS3", "PHP", "jQuery", "WooCommerce"),
                features = listOf(
                    "Exit-intent popups",
                    "Discount campaigns",
                    "Multi-channel recovery",
                    "Performance analytics"
                )
            ),
            PortfolioProject(
                id = 3,
                name = "UpsellWP",
                description = "Advanced upselling and cross-selling platform for WordPress",
                url = "https://upsellwp.com/",
                role = "Full-stack WordPress Developer",
                technologies = listOf("WordPress", "PHP", "AJAX", "MySQL", "WooCommerce"),
                features = listOf(
                    "One-click upsells",
                    "Smart product recommendations",
                    "Campaign scheduling",
                    "A/B testing"
                )
            ),
            PortfolioProject(
                id = 4,
                name = "WPLoyalty",
                description = "Comprehensive loyalty program solution for WooCommerce stores",
                url = "https://wployalty.net/",
                role = "WordPress Plugin Developer",
                technologies = listOf("WordPress", "PHP", "JavaScript", "CSS3", "REST API"),
                features = listOf(
                    "Points & rewards system",
                    "Tier-based memberships",
                    "Gamification elements",
                    "Social sharing rewards"
                )
            ),
            PortfolioProject(
                id = 5,
                name = "Yuko",
                description = "Innovative SaaS platform with WordPress integration",
                url = "https://yuko.so/",
                role = "Web Designer & Developer",
                technologies = listOf("WordPress", "React", "TypeScript", "SaaS", "Cloud"),
                features = listOf(
                    "Modern dashboard design",
                    "Real-time analytics",
                    "API integrations",
                    "Responsive web design"
                )
            )
        )
    }
    
    fun getSkills(): List<Skill> {
        return listOf(
            Skill("WordPress Development", 95, "🛠️"),
            Skill("Web Design (UI/UX)", 90, "🎨"),
            Skill("PHP", 88, "🐘"),
            Skill("JavaScript", 85, "⚡"),
            Skill("WooCommerce", 92, "🛒"),
            Skill("CSS3/SASS", 87, "🎯"),
            Skill("React", 80, "⚛️"),
            Skill("Plugin Development", 93, "🔌")
        )
    }
    
    fun getExperience(): List<Experience> {
        return listOf(
            Experience(
                title = "Senior WordPress Developer",
                duration = "2023 - Present",
                description = "Leading development of premium WordPress plugins and themes"
            ),
            Experience(
                title = "WordPress Developer",
                duration = "2022 - 2023",
                description = "Developed custom solutions for multiple SaaS products"
            )
        )
    }
}
