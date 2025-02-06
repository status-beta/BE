package com.status.api

import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper
import com.epages.restdocs.apispec.ResourceDocumentation.parameterWithName
import com.epages.restdocs.apispec.ResourceSnippetParametersBuilder
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.restdocs.payload.JsonFieldType
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


class SampleControllerTest: BaseTest() {

    @Test
    @DisplayName("sample get 테스트")
    fun getTest() {
        val sampleId = "aaa"
        mockMvc.perform(
            get("/api/v1/samples/{sampleId}", sampleId)
        )
            .andExpect(status().isOk())
            .andExpect(jsonPath("sampleId", `is`(sampleId)))
            .andExpect(jsonPath("name", `is`("sample-$sampleId")))
            .andDo(
                MockMvcRestDocumentationWrapper.document(
                    identifier = "sample",
                    resourceDetails = ResourceSnippetParametersBuilder()
                        .tag("sample")
                        .description("get 테스트")
                        .pathParameters(
                            parameterWithName("sampleId").description("the sample id")
                        )
                        .responseFields(
                            fieldWithPath("sampleId").type(JsonFieldType.STRING).description("The sample identifier."),
                            fieldWithPath("name").type(JsonFieldType.STRING).description("The name of sample")
                        )
                )
            )
    }
}