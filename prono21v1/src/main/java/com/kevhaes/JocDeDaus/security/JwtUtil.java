package com.kevhaes.JocDeDaus.security;

import static java.util.Collections.emptyList;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.kevhaes.JocDeDaus.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

	@Autowired
	UserService userService;

	// Método para crear el JWT y enviarlo al cliente en el header de la respuesta
	static void addAuthentication(HttpServletResponse res, String username) throws IOException {

		String token = Jwts.builder().setSubject(username)

				// Vamos a asignar un tiempo de expiracion de 1 minuto
				// solo con fines demostrativos en el video que hay al final

				///// ---->///// .setExpiration(new Date(System.currentTimeMillis() + 60000))

				.setExpiration(new Date(System.currentTimeMillis() + 604800000))
				// set to 1 week

				/*
				 * You should refresh the token every 15 minutes (900,000), but you don't need
				 * to let the user authenticate again to do so. After authenticating, hand out a
				 * JWT that is valid for 15 minutes. Let the client refresh the token whenever
				 * it is expired. If this is done within seven days, a new JWT can be obtained
				 * without re-authenticating. After a session is inactive for seven days,
				 * require authentication before handing out a new JWT token. This way you can
				 * for example require authentication after a user changed their password.
				 */

				// Hash con el que firmaremos la clave
				.signWith(SignatureAlgorithm.HS512, "javeros").compact();

		// agregamos al encabezado el token

		res.addHeader("Authorization", "Bearer " + token);

	}

	// Método para validar el token enviado por el cliente
	static Authentication getAuthentication(HttpServletRequest request) {

		// Obtenemos el token que viene en el encabezado de la peticion
		String token = request.getHeader("Authorization");

		// si hay un token presente, entonces lo validamos
		if (token != null) {
			String user = Jwts.parser().setSigningKey("javeros").parseClaimsJws(token.replace("Bearer", "")) // este //
																												// metodo
																												// es
																												// el
																												// que
																												// valida
					.getBody().getSubject();

			// Recordamos que para las demás peticiones que no sean /login
			// no requerimos una autenticacion por username/password
			// por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin
			// password
			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}
}