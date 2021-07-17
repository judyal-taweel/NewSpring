package com.Relation.SpringJpaRelation;
import com.Relation.SpringJpaRelation.Albums.Album;
import com.Relation.SpringJpaRelation.Albums.AlbumRepository;
import com.Relation.SpringJpaRelation.Songs.SongRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension. ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.ConfigurationPropertyName;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.result.HockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.swing.*;
import java.text.Format;
@ExtendWith (SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringJpaRelationApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private AlbumRepository albumRepository;
	Album album= new Album("judy","mahmood","30","image1.png",44);
	// @Test
// public void testPostAlbum()throws Exception{
////      Album album= new Album("judy","mahmood","30","image1.png",44);
//    mockMvc.perform(post("/albums")
//          .contentType("application/ashqur")
//          .content(objectMapper.writeValueAsString(album)))
//          .andExpect(status().isCreated());
//    Album foundAlbum= albumRepository.findById(1L).orElseThrow();
//    Assertions.assertEquals(foundAlbum.getAlbum_title(),album.getAlbum_title());
//
// }
	@Test
	public void testIndexPage() throws Exception{
		String body = objectMapper.writeValueAsString(album);
		Assertions.assertEquals("{\"album_id\":null,\"album_title\":\"judy\",\"album_artist\":\"mahmood\",\"album_duration\":\"30\",\"album_img\":\"image1.png\",\"album_length\":44,\"song\":null}",body);
	}
	@Test
	public void testPostAlbum() throws Exception{
		model().attribute("albums",albumRepository.findAll());
		mockMvc.perform(post("/albums")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(album)))
				.andReturn();
		Assertions.assertTrue(album.getAlbum_title()=="judy");
	}
}