package br.jus.tjms.sgpd.service.rest;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.NonTypedScalarSerializerBase;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonConfig implements ContextResolver<ObjectMapper> {

	private final ObjectMapper mapper;

	public JacksonConfig() {
		mapper = new ObjectMapper();
		
		// define formato para des/serialização de datas
		//MMM dd, yyyy hh:mm:ss aa
		DateFormatSymbols dfs = new DateFormatSymbols(Locale.ENGLISH);
		mapper.setDateFormat(new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa",dfs));
		
		// inclui campos nulos na serialização
		mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
		
		// configura des/serialização de booleans
		SimpleModule booleanModule = new SimpleModule("BooleanAsString", new Version(1, 0, 0, null, null, null));

		booleanModule.addSerializer(new NonTypedScalarSerializerBase<Boolean>(Boolean.class) {

			private static final long serialVersionUID = 1538316685467869718L;

			@Override
			public void serialize(Boolean value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
				jgen.writeString(value.toString());				
			}
			
		});
		
		// configura des/serialização de enums
		mapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		
		mapper.registerModule(booleanModule);
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return mapper;
	}
	
}