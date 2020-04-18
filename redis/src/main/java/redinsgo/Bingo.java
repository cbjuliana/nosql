package redinsgo;

import java.util.List;

import redis.clients.jedis.Jedis;

public class Bingo {
	
	private Jedis redis;
	
	public Bingo() {
		
		redis = Redis.getInstance();
		System.out.println("Conectado ao redis...");
		System.out.println("");
		
	}

	public void jogar() {
		
		System.out.println("Configurando o jogo...");
		System.out.println("");	

		criarNumerosParaGeracaoDasCartelasESorteio();

		criarJogadores();
		
		System.out.println("");
		System.out.println("Iniciando jogo...");
		System.out.println("");
		
		boolean bingo = false;
		
		while (bingo != true) {

			String numeroSorteado = sortearNumero();

			// verificando se algum jogador acertou o número sorteado
			for (int i = 1; i <= 50; i++) {

				if (redis.sismember("cartela" + i, numeroSorteado)) {

					redis.zincrby("score", 1, "score" + i);

					System.out.println("User" + i + " ACERTOU o número: " + numeroSorteado + " SCORE: "
							+ redis.zscore("score", "score" + i));

					// verifica se o jogador fez bingo
					if (redis.zscore("score", "score" + i) == 15) {

						bingo = true;

						System.out.println(
								"User" + i + " fez BINGO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

					}

				}

			}

		}

		System.out.println("");
		System.out.println("Fim do jogo...");
		System.out.println("");

		mostrarNumerosNaoSorteados();
		
		excluirCartelas();		
	}

	private void mostrarNumerosNaoSorteados() {
		System.out.println("Números que não foram sorteados: " + redis.smembers("numeros"));
	}

	private String sortearNumero() {
		String numeroSorteado = redis.srandmember("numeros", 1).get(0);

		redis.srem("numeros", numeroSorteado);

		System.out.println("NÚMERO SORTEADO: " + numeroSorteado);
		return numeroSorteado;
	}

	private void criarJogadores() {
		// criando os jogadores
		System.out.println("Criando os jogadores do bingo");
		for (int i = 1; i <= 50; i++) {

			redis.hset("user" + i, "name", "user" + i);
			redis.hset("user" + i, "bcartela", "cartela" + i);
			redis.hset("user" + i, "bscore", "score" + i);

			redis.zadd("score", 0, "score" + i);

			// criando a cartela do jogador
			List<String> numerosCartela = redis.srandmember("numeros", 15);

			for (String numeroCartela : numerosCartela) {

				redis.sadd("cartela" + i, numeroCartela);

			}
			System.out.println("Criada a cartela do jogador User" + i + ": " + redis.smembers("cartela" + i));

		}
	}

	private void criarNumerosParaGeracaoDasCartelasESorteio() {
		// gerando números de 1 à 99 para geração de cartelas e sorteio do bingo		
		String [] numeros = new String[99];			
		for (int i = 0; i <= 98; i++) {
			numeros[i] = String.valueOf(i+1);
		}
		redis.sadd("numeros", numeros);
		System.out.println("Números para geração das cartelas e sorteio do bingo");	
		System.out.println(redis.smembers("numeros"));
	}
	
	private void excluirCartelas() {
		String [] cartelas = new String[50];
		for (int i = 0; i <= 49; i++) {
			cartelas[i] = "cartela" + (i+1);
		}
		redis.del(cartelas);		
	}

	

}
