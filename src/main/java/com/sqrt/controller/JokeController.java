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

@WebServlet(urlPatterns={"/"})
public final class JokeController extends HttpServlet {

	private static final List<String> jokes = Arrays.asList(
		"I Googled 'how to start a wildfire'. I got 48,500 matches.",
		"My ex-wife still misses me. But her aim is steadily improving.",
		"My boss told me to have a good day .. so I went home.",
		"If I got 50 cents for every failed math exam, I'd have $6.30 now.",
		"I called the hospital but the line was dead.",
		"If we shouldn't eat at night, why do they put a light in the fridge?",
		"Chocolate is the best investment. You buy 100g – you gain 2kg!",
		"Bill Gates and I have a combined fortune of approximately 80 billion dollars.",
		"You know you're ugly when you get handed the camera every time they make a group photo.",
		"My dog used to chase people on a bike a lot. It got so bad, finally I had to take his bike away.",
		"A woman walks into a library and asked if they had any books about paranoia. The librarian answered they were right behind her.",
		"I know a lot of jokes about unemployed people but none of them work.",
		"I just wrote a book on reverse psychology. Do *not* read it!",
		"Alcohol! Because no great story started with someone eating a salad.",
		"Always remember you're unique, just like everyone else.",
		"So what if I don't know what 'Armageddon' means? It's not the end of the world.",
		"A lot of people cry when they cut onions. The trick is not to form an emotional bond.",
		"I dressed my dog up as a cat for Halloween. Now he won't come when I call him.",
		"Smile and the world smiles with you. Fart and the world suddenly stops smiling.",
		"I have a parrot and it talks. Sadly it did not say it was hungry, so it died.",
		"I asked God for a bike, but I know God doesn't work that way. So I stole a bike and asked for forgiveness.",
		"Light travels faster than sound. This is why some people appear bright until you hear them speak.",
		"What has four legs and an arm? A happy pit bull.",
		"I thought I wanted a career, turns out I just wanted paychecks."
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
