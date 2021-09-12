package br.inatel.cdg.algebra.scene;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import br.inatel.cdg.algebra.reta.Ponto;
import br.inatel.cdg.algebra.reta.Reta;

public class ScenePrincipal {

    private Button btnTeste, btnCalcCoefLinear; //Button representa botoes
    private Label labelP1x, labelP1y, labelP2x, labelP2y; //Label representam rótulos
    private TextField textField1, textField2, textField3, textField4,textField5,textField7; //TextField Representam áreas de texto


    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelP1x = new Label("P1.x:"); //rótulos
        textField1 = new TextField(); //área de texto onde vc digitara alguma coisa
        labelP1y = new Label("P1.y:");
        textField3 = new TextField();
        labelP2x = new Label("P2.x:");
        textField5 = new TextField();
        labelP2y = new Label("P2.y:");
        textField7 = new TextField();


        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal = new HBox(labelP1x, textField1); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal1 = new HBox(labelP1y, textField3);
        HBox grupoHorizontal2 = new HBox(labelP2x, textField5);
        HBox grupoHorizontal3 = new HBox(labelP2y, textField7);

        //Agora vamos criar a area que mostrará o que foi digitado
        textField2 = new TextField();
        textField2.setEditable(false);//vamos deixar false para apenas mostrar texto
        textField2.setText("Coef Ang: ");

        textField4 = new TextField();
        textField4.setEditable(false);//vamos deixar false para apenas mostrar texto
        textField4.setText("Coef Lin: ");

        //Criamos o botão
        btnTeste = new Button("Executar Ação");
        //Criamos a ação que o botão responderá as ser pressionado
        btnTeste.setOnAction(evento -> {
            Reta reta = construirReta();
            //Aqui dentro é a ação que será executado ao pressionar o botão
            textField2.setText("Coef Angular: " + reta.calcCoeficienteAngular());//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
            //Aqui dentro é a ação que será executado ao pressionar o botão
            textField4.setText("Coef Linear: " + textField7.getText());//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grupoHorizontal, grupoHorizontal1,grupoHorizontal2,grupoHorizontal3,textField2,textField4,btnTeste);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado

        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

    //Função interna que cria uma br.inatel.cdg.algebra.reta!
    private Reta construirReta(){
        Ponto p1 = new Ponto(Double.parseDouble(textField1.getText()),
                Double.parseDouble(textField3.getText()));

        Ponto p2 = new Ponto(Double.parseDouble(textField5.getText()),
                Double.parseDouble(textField7.getText()));

        Reta reta = new Reta(p1,p2);
        return reta;
    }

}
