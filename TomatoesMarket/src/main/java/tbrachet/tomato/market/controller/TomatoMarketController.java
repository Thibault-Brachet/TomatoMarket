package tbrachet.tomato.market.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomatoMarketController {

	private List<TomatoMarket> listTomatoMarkets;
	private final AtomicLong counter = new AtomicLong();
	private List<String> providers = Arrays.asList("Heinz", "Hunt's", "Del Monte", "Le Ol' Granma");;
	private Random random = new Random();
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@RequestMapping("/data")
	public List<TomatoMarket> generateTomatoMarketData(@RequestParam(value = "size", defaultValue = "3") String size) {

		listTomatoMarkets = new ArrayList<TomatoMarket>();

		if (isInteger(size)) {
			int sizeInt = Integer.parseInt(size);

			if (sizeInt > 0) {

				TomatoMarket tomatoMarket;

				for (int i = 0; i < sizeInt; i++) {

					try {
						long timestampBeginningOfTheYear = dateFormat.parse("01/01/2016").getTime();
						long timestampToday = new Date().getTime();

						tomatoMarket = new TomatoMarket(counter.incrementAndGet(), numberOfTomatoesGenerator(),
								getRandomList(providers), timestampGenerator(timestampBeginningOfTheYear, timestampToday));

						listTomatoMarkets.add(tomatoMarket);

					} catch (ParseException e) {
						e.printStackTrace();
					}
				}
				
				Collections.sort(listTomatoMarkets);

			}

		}

		return listTomatoMarkets;

	}

	private static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	private int numberOfTomatoesGenerator() {
		int leftLimit = 1;
		int rightLimit = 2000;
		int generatedLong = new RandomDataGenerator().nextInt(leftLimit, rightLimit);
		return generatedLong;
	}

	private long timestampGenerator(long timestampBeginningOfYear, long timestampToday) {
		long generatedLong = new RandomDataGenerator().nextLong(timestampBeginningOfYear, timestampToday);
		return generatedLong;
	}

	public String getRandomList(List<String> list) {

		int index = random.nextInt(list.size());
		return list.get(index);

	}

}
