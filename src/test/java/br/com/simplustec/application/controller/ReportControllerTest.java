package br.com.simplustec.application.controller;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import br.com.simplustec.application.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ReportControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testReportInMemorySuccess() throws Exception {
		this.mockMvc.perform(get("/report/createDefaultReportInMemory/" ))
                .andDo(print())
                .andExpect(status().isOk());
	}
	
	@Test
	public void checkFileInMemoryContent() throws Exception {
		String content = "application/octet-stream";
		MvcResult result = this.mockMvc.perform(get("/report/createDefaultReportInMemory/" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
		
		assertThat(content, equalTo(result.getResponse().getContentType()));
	}
	
	@Test
	public void testReportWritingInDisckSuccess() throws Exception {
		this.mockMvc.perform(get("/report/createDefaultReport/" ))
                .andDo(print())
                .andExpect(status().isOk());
	}
	
	@Test
	public void checkFileContenInMemorySucess() throws Exception {
		String content = "application/octet-stream";
		MvcResult result = this.mockMvc.perform(get("/report/createDefaultReport/" ))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
		
		assertThat(content, equalTo(result.getResponse().getContentType()));
	}

}
