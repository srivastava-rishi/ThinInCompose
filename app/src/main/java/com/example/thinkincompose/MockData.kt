package com.example.thinkincompose

object MockData {


    private var mockList: List<NewsItem> = emptyList();


    fun mockData(): List<NewsItem> {
        val userDataList = listOf(
            UserData(
                name = "John Doe",
                photoUrl = "https://plus.unsplash.com/premium_photo-1665941065977-993d9105662a?q=80&w=3386&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            UserData(
                name = "Jane Smith",
                photoUrl = "https://images.unsplash.com/photo-1463453091185-61582044d556?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzB8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Alice Johnson",
                photoUrl = "https://images.unsplash.com/photo-1488426862026-3ee34a7d66df?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzF8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Bob Brown",
                photoUrl = "https://images.unsplash.com/photo-1522556189639-b150ed9c4330?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTJ8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Charlie Davis",
                photoUrl = "https://images.unsplash.com/photo-1589156288859-f0cb0d82b065?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTh8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Emily Wilson",
                photoUrl = "https://images.unsplash.com/photo-1485546246426-74dc88dec4d9?q=80&w=3538&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            ),
            UserData(
                name = "Frank Harris",
                photoUrl = "https://images.unsplash.com/photo-1500648767791-00dcc994a43e?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Njh8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Grace Lee",
                photoUrl = "https://images.unsplash.com/photo-1560250097-0b93528c311a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nzh8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Hannah Clark",
                photoUrl = "https://images.unsplash.com/photo-1489424731084-a5d8b219a5bb?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8ODJ8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            ),
            UserData(
                name = "Ian Martinez",
                photoUrl = "https://plus.unsplash.com/premium_photo-1670588776216-424f6d1aa8a4?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8ODl8fHBlb3BsZXxlbnwwfHwwfHx8MA%3D%3D"
            )
        )
        mockList = listOf(
            NewsItem(
                id = "1",
                headline = "Global leaders convene at the annual summit to discuss pressing international economic and political challenges affecting the world.",
                description = "In an unprecedented gathering, global leaders from various countries convened at the annual summit to address the pressing economic and political challenges that are currently affecting the world. The summit, held in a renowned international venue, saw participation from heads of state, policy makers, economists, and industry leaders. The agenda for the summit included discussions on global economic recovery post-pandemic, climate change initiatives, international trade policies, and geopolitical tensions. Experts presented detailed reports on the current state of the global economy and proposed strategic measures to foster sustainable growth. Keynote speakers emphasized the importance of international cooperation and multilateral agreements to tackle these challenges effectively. The summit also featured several breakout sessions focusing on specific regions and sectors, providing a platform for in-depth dialogue and exchange of ideas. The event concluded with a joint declaration outlining the commitments and action plans agreed upon by the participating nations. This summit is expected to pave the way for significant policy changes and collaborative efforts aimed at ensuring a stable and prosperous future for the global community.",
                category = "World",
                time = "Wed, 05 July 2024",
                image = "https://images.unsplash.com/photo-1470071459604-3b5ec3a7fe05?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NHx8bmF0dXJlfGVufDB8fDB8fHww",
                userData = userDataList[0]
            ),
            NewsItem(
                id = "2",
                headline = "New healthcare policies unveiled by government aim to revolutionize the national healthcare system and improve public health outcomes.",
                description = "The government has announced a comprehensive set of new healthcare policies designed to revolutionize the national healthcare system and significantly improve public health outcomes. The announcement, made by the health minister, includes several groundbreaking initiatives aimed at making healthcare more accessible, affordable, and efficient for all citizens. One of the key components of the new policies is the introduction of universal healthcare coverage, ensuring that every individual has access to essential medical services without financial hardship. Additionally, the policies emphasize the modernization of healthcare infrastructure, with plans to build new hospitals and upgrade existing facilities with state-of-the-art technology. Preventive care and early diagnosis are also prioritized, with increased funding for public health campaigns, vaccination programs, and regular health screenings. The government is also committed to addressing the shortage of healthcare professionals by offering incentives for medical education and training. The new policies have been welcomed by healthcare experts and advocacy groups, who believe that these reforms will lead to better health outcomes and a more resilient healthcare system. The implementation of these policies will be closely monitored to ensure that the intended benefits are realized across the nation.",
                category = "Politics",
                time = "Thu, 06 July 2024",
                image = "https://images.unsplash.com/photo-1586348943529-beaae6c28db9?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTB8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[1]
            ),
            NewsItem(
                id = "3",
                headline = "Local sports team clinches championship title in a dramatic final match, sparking celebrations among fans and community members.",
                description = "In a thrilling conclusion to the sports season, the local team has clinched the championship title in a dramatic final match that left fans on the edge of their seats. The highly anticipated game was held at the city's main stadium, which was packed with enthusiastic supporters from both sides. From the very beginning, the match was intense, with both teams showcasing exceptional skill and determination. The score remained close throughout the game, with each side taking turns to lead. In the final moments, the local team's star player scored a decisive goal, securing the victory and sending the crowd into a frenzy. The final whistle was met with loud cheers and celebratory chants, as fans poured onto the streets to celebrate the team's hard-earned triumph. The victory is seen as a significant achievement for the team, which has worked tirelessly throughout the season. Community leaders have also expressed their pride in the team's success, highlighting the positive impact of sports in bringing people together and fostering a sense of unity. The championship win is expected to boost the team's profile and inspire future generations of athletes in the community.",
                category = "Sports",
                time = "Fri, 07 July 2024",
                image = "https://plus.unsplash.com/premium_photo-1675827055620-24d540e0892a?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8bmF0dXJlfGVufDB8fDB8fHww",
                userData = userDataList[2]
            ),
            NewsItem(
                id = "4",
                headline = "Renowned actor stars in the highly anticipated new blockbuster film, generating buzz and excitement among fans and critics alike.",
                description = "The entertainment industry is abuzz with excitement as a renowned actor takes the lead role in the highly anticipated new blockbuster film. The movie, which has been in the making for over a year, promises to be a cinematic masterpiece, featuring a stellar cast, breathtaking visuals, and a gripping storyline. The actor, known for their versatile performances and immense popularity, has once again captivated audiences with their portrayal of the protagonist. The film's director, a celebrated figure in the industry, has praised the actor's dedication and talent, stating that their performance is one of the best he has ever seen. The plot of the movie revolves around a thrilling adventure that takes viewers on a roller-coaster ride of emotions, with unexpected twists and turns that keep them on the edge of their seats. Early screenings of the film have received rave reviews from critics, who have lauded the film's direction, screenplay, and performances. Fans are eagerly awaiting the film's release, which is expected to break box office records and set new benchmarks in the industry. The film's marketing campaign has also generated significant buzz, with trailers and promotional events creating widespread anticipation.",
                category = "Entertainment",
                time = "Sat, 08 July 2024",
                image = "https://plus.unsplash.com/premium_photo-1675368244123-082a84cf3072?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[3]
            ),
            NewsItem(
                id = "5",
                headline = "Leading tech company unveils cutting-edge AI technology that promises to revolutionize various industries and enhance everyday life.",
                description = "In a landmark event, a leading tech company has unveiled its latest innovation in artificial intelligence (AI) technology, which is set to revolutionize various industries and significantly enhance everyday life. The new AI system, developed by a team of top engineers and researchers, boasts advanced capabilities that surpass existing technologies. During the launch event, the company's CEO demonstrated the AI's impressive features, including its ability to process and analyze vast amounts of data in real-time, its superior problem-solving skills, and its intuitive user interface. The AI technology is designed to be adaptable and scalable, making it suitable for applications in healthcare, finance, manufacturing, and more. In the healthcare sector, the AI can assist doctors in diagnosing diseases with greater accuracy, while in finance, it can optimize trading strategies and manage risks. The manufacturing industry can benefit from AI-powered automation and predictive maintenance, leading to increased efficiency and reduced downtime. The company's CEO emphasized that the new AI technology is not just about improving business operations but also about enhancing the quality of life for individuals. By integrating AI into smart homes, personal assistants, and other consumer products, the company aims to create a seamless and intelligent user experience. The launch has garnered widespread attention and is being hailed as a major breakthrough in the field of artificial intelligence.",
                category = "Technology",
                time = "Sun, 09 July 2024",
                image = "https://images.unsplash.com/photo-1510784722466-f2aa9c52fff6?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjJ8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[4]
            ),
            NewsItem(
                id = "6",
                headline = "Stock market experiences unprecedented growth amid positive economic outlook and investor confidence, boosting market sentiment and activity.",
                description = "The stock market has experienced unprecedented growth in recent weeks, driven by a positive economic outlook and increasing investor confidence. This remarkable uptrend has seen major indices reaching new all-time highs, with gains spread across various sectors, including technology, healthcare, and consumer goods. Market analysts attribute this surge to a combination of strong corporate earnings reports, favorable economic data, and optimistic forecasts for future growth. The recent announcements of major government stimulus packages and monetary policies aimed at supporting economic recovery have also played a crucial role in boosting market sentiment. Investors are particularly encouraged by the resilience shown by businesses in adapting to the post-pandemic landscape, as well as the rapid pace of technological advancements driving productivity and innovation. The influx of retail investors into the market, facilitated by online trading platforms, has further contributed to the heightened trading activity and liquidity. Experts caution, however, that while the current bullish trend is promising, it is essential for investors to remain vigilant and diversify their portfolios to mitigate potential risks. As the market continues to evolve, close attention to economic indicators and corporate performance will be key to navigating the opportunities and challenges ahead. This period of growth is seen as a pivotal moment for the global economy, reflecting a renewed sense of optimism and potential for sustained progress.",
                category = "Business",
                time = "Mon, 10 July 2024",
                image = "https://images.unsplash.com/photo-1490730141103-6cac27aaab94?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MzZ8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[5]
            ),
            NewsItem(
                id = "7",
                headline = "Groundbreaking medical discovery promises new treatments and hope for millions suffering from chronic illnesses and conditions.",
                description = "In a major medical breakthrough, researchers have announced the discovery of a groundbreaking treatment that promises new hope for millions of individuals suffering from chronic illnesses and conditions. The new treatment, developed after years of rigorous research and clinical trials, targets the underlying causes of various chronic diseases, offering a more effective and sustainable solution compared to existing therapies. The research team, comprising experts from leading medical institutions, revealed that the treatment works by modulating the immune system and repairing damaged tissues at the cellular level. Preliminary results from clinical trials have shown significant improvements in patients' symptoms and overall quality of life. For instance, individuals with autoimmune diseases experienced reduced inflammation and pain, while those with degenerative conditions reported enhanced mobility and function. The discovery has been hailed as a milestone in medical science, with many experts hailing it as a game-changer in the field of healthcare. Patient advocacy groups have also expressed optimism, highlighting the potential of this treatment to transform the lives of those affected by chronic conditions. The researchers are now working towards obtaining regulatory approvals and scaling up production to make the treatment widely available. This discovery underscores the importance of continued investment in medical research and innovation, as it opens new avenues for tackling some of the most persistent health challenges.",
                category = "Health",
                time = "Tue, 11 July 2024",
                image = "https://plus.unsplash.com/premium_photo-1675433344518-21eb72dfc7a5?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDF8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[6]
            ),
            NewsItem(
                id = "8",
                headline = "Scientists make groundbreaking discovery of new species in remote rainforest, shedding light on biodiversity and ecosystem dynamics.",
                description = "A team of scientists has made a groundbreaking discovery in a remote rainforest, uncovering a new species that sheds light on the region's rich biodiversity and complex ecosystem dynamics. The discovery was made during an extensive research expedition aimed at studying the unique flora and fauna of the area. The new species, which has been named after the region, exhibits distinctive characteristics that set it apart from known species, highlighting the incredible diversity of life in the rainforest. Detailed observations and genetic analyses confirmed the uniqueness of the species, which belongs to a previously undocumented genus. The discovery has significant implications for our understanding of biodiversity and the intricate relationships within ecosystems. It also underscores the importance of conserving these habitats, which are home to countless undiscovered species and play a crucial role in maintaining ecological balance. The research team has called for increased efforts to protect the rainforest from threats such as deforestation and climate change, emphasizing the need for sustainable practices that preserve these vital ecosystems. The findings have been published in a leading scientific journal, where they have garnered attention from the global scientific community. This discovery is expected to inspire further exploration and research, contributing to our knowledge of the natural world and the conservation of its treasures.",
                category = "Science",
                time = "Wed, 12 July 2024",
                image = "https://images.unsplash.com/photo-1497449493050-aad1e7cad165?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NDd8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[7]
            ),
            NewsItem(
                id = "9",
                headline = "Top experts share essential tips for maintaining a healthy lifestyle, focusing on diet, exercise, and mental well-being.",
                description = "Leading health and wellness experts have come together to share essential tips for maintaining a healthy lifestyle, emphasizing the importance of a balanced diet, regular exercise, and mental well-being. These tips, based on the latest research and best practices, aim to help individuals lead healthier and more fulfilling lives. One of the primary recommendations is to adopt a nutritious diet that includes a variety of fruits, vegetables, whole grains, and lean proteins. Experts advise limiting the intake of processed foods, sugars, and unhealthy fats, which can contribute to chronic diseases such as obesity, diabetes, and heart disease. Regular physical activity is also crucial for overall health, with experts suggesting at least 150 minutes of moderate-intensity exercise per week. This can include activities such as walking, cycling, swimming, or strength training. In addition to physical health, mental well-being plays a vital role in a healthy lifestyle. Techniques such as mindfulness, meditation, and stress management are recommended to maintain mental balance and reduce the risk of anxiety and depression. Adequate sleep, social connections, and finding time for hobbies and relaxation are also important aspects of a holistic approach to health. The experts stress that small, consistent changes can lead to significant improvements in health over time. By following these tips, individuals can enhance their overall well-being and enjoy a higher quality of life.",
                category = "Lifestyle",
                time = "Thu, 13 July 2024",
                image = "https://images.unsplash.com/photo-1547036967-23d11aacaee0?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NTV8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[8]
            ),
            NewsItem(
                id = "10",
                headline = "Discover the world's most breathtaking travel destinations and unique cultural experiences, from hidden gems to iconic landmarks.",
                description = "Travel enthusiasts are invited to explore some of the world's most breathtaking destinations and unique cultural experiences, ranging from hidden gems to iconic landmarks. Whether you are an adventurer seeking off-the-beaten-path locales or a traveler eager to visit renowned sites, there is something for everyone to discover. Among the top travel destinations are stunning natural wonders such as the Grand Canyon, the Great Barrier Reef, and the Northern Lights, each offering awe-inspiring beauty and unforgettable experiences. For those interested in rich cultural heritage, cities like Kyoto, Rome, and Marrakech provide a deep dive into history, architecture, and local traditions. Exploring these cities, visitors can enjoy ancient temples, historic ruins, and bustling markets, all while immersing themselves in the local way of life. Travelers looking for relaxation can find solace in serene beach destinations like the Maldives, Bora Bora, and the Seychelles, where crystal-clear waters and pristine sands offer the perfect backdrop for unwinding. Adventure seekers can embark on thrilling activities such as hiking in Patagonia, safaris in Kenya, or diving in Indonesia's coral reefs. Each destination not only offers unique sights and activities but also opportunities to connect with people from different cultures, fostering a deeper understanding and appreciation of the world. By planning a trip that aligns with personal interests and travel goals, individuals can create lasting memories and enrich their lives through the joy of exploration.",
                category = "Travel",
                time = "Fri, 14 July 2024",
                image = "https://images.unsplash.com/photo-1536431311719-398b6704d4cc?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8NjJ8fG5hdHVyZXxlbnwwfHwwfHx8MA%3D%3D",
                userData = userDataList[9]
            )
        )
        return mockList
    }


    fun getNewsById(id: String): NewsItem? {
        return mockList.firstOrNull() { it.id == id }
    }
}

data class NewsItem(
    val id: String,
    val headline: String,
    val description: String,
    val category: String,
    val time: String,
    val image: String,
    val userData: UserData
)

data class UserData(
    val name: String,
    val photoUrl: String,
)