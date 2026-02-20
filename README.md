🎮 Projeto: Evolução Gráfica (Danki Code)
Este repositório contém o progresso técnico desenvolvido durante o módulo de Gráficos e Sprites do curso de Desenvolvimento de Games da Danki Code. O foco aqui foi entender como a máquina renderiza imagens, como otimizar o processamento visual e como dar vida a personagens através de animações.

🚀 Tecnologias Utilizadas
Java (Lógica central)

Java AWT / Swing (Interface e renderização)

Canvas & JFrame (Manipulação de tela)

🧠 Aprendizados por Etapa
Dividi meu aprendizado em 7 marcos fundamentais, simulando a estrutura de uma engine profissional:

1. A Fundação (Frame e Canvas)
Configuração da janela do jogo (JFrame) e do espaço de desenho (Canvas). Aprendi a importância de separar a lógica do jogo da renderização visual.

2. O Coração do Game: Game Loop Profissional
Implementação de um Game Loop robusto utilizando System.nanoTime(). Isso garante que o jogo rode na mesma velocidade em qualquer computador (controle de FPS e UPS).

3. Otimização com Buffers
Uso de BufferStrategy e BufferedImage. Aprendi a desenhar "nos bastidores" antes de enviar para a tela, eliminando o efeito de flickering (piscagem) nas imagens.

4. Debug e Geometria
Criação de ferramentas de debug para visualizar áreas de colisão e renderização de formas geométricas simples antes de implementar a arte final.

5. Renderizando Strings
Manipulação de fontes e renderização de textos dinâmicos na tela, essencial para sistemas de interface (UI), pontuação e menus.

6. Sistema de Spritesheets
Implementação de um sistema para recortar e renderizar sprites a partir de uma Spritesheet única.

Player: Criação da classe do jogador e extração dos frames corretos.

7. Animações e Matemática (Rotação)
O nível final!

Criação de sistemas de Timer para troca de frames de animação.

Uso de Graphics2D para aplicar rotações em objetos, permitindo movimentos mais fluidos e dinâmicos.

🛠️ Como Executar
Certifique-se de ter o JDK instalado.

Clone o repositório:

Bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
Compile e execute a classe principal (geralmente Game.java).

🖼️ Resultado Visual
![Animação](https://github.com/user-attachments/assets/992e7a14-a801-4808-9f03-db582d3e58ab)

"O desenvolvimento de jogos é a mistura perfeita entre arte e matemática."
