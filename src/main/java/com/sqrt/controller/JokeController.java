package com.sqrt.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns={"/*"})
public final class JokeController extends HttpServlet {

	private static final List<String> jokes = Arrays.asList(
		"I Googled 'how to start a wildfire'. I got 48,500 matches.",
		"My ex-wife still misses me. But her aim is steadily improving.",
		"My boss told me to have a good day .. so I went home.",
		"If I got 50 cents for every failed math exam, I'd have $6.30 now.",
		"I called the hospital but the line was dead.",
		"I heard women love a man in uniform. Can't wait to start working at McDonalds.",
		"If we shouldn't eat at night, why do they put a light in the fridge?",
		"Chocolate is the best investment. You buy 100g – you gain 2kg!",
		"I and Bill Gates have a combined fortune of approximately 80 billion dollars.",
		"You know you're ugly when you get handed the camera every time they make a group photo.",
		"I hate people who take drugs. DEA is the worst.",
		"My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
		"A woman walks into a library and asked if they had any books about paranoia. The librarian answered they were right behind her.",
		"I know a lot of jokes about unemployed people but none of them work.",
		"I just wrote a book on reverse psychology. Do *not* read it!",
		"Alcohol! Because no great story started with someone eating a salad.",
		"Always remember you're unique, just like everyone else."
	);

	private static final Random random = new Random();

	@Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, java.io.IOException {
		final int randomNum = random.nextInt(jokes.size());
		final String joke = jokes.get(randomNum);
		final Writer writer = response.getWriter();
		writer.write(joke);
		writer.flush();
	}

}
