package com.status.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/samples")
class SampleController {

    @GetMapping("{sampleId}")
    fun getTest(
        @PathVariable sampleId: String
    ): SampleResponse {
        return SampleResponse(sampleId, "sample-$sampleId")
    }

    data class SampleResponse(
        val sampleId: String,
        val name: String,
    )
}