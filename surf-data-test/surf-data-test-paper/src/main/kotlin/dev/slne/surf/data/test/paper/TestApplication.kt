package dev.slne.surf.data.test.paper

import dev.slne.surf.data.DataApplication

@DataApplication(
    scanBasePackages = ["dev.slne.surf.data.test.paper"],
    feignBasePackages = ["dev.slne.surf.data.test.paper"]
)
class TestApplication