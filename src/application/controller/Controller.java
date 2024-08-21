package application.controller;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

import application.model.Estado;
import application.model.Usuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable
{

	@FXML
	private TableColumn<Usuario, String> columnNome;
	@FXML
	private TableColumn<Usuario, String> columnCpf;
	@FXML
	private TableColumn<Usuario, String> columnTelefone;
	@FXML
	private TableColumn<Usuario, String> columnEndereco;
	@FXML
	private TableColumn<Usuario, String> columnNumero;
	@FXML
	private TableColumn<Usuario, String> columnCidade;
	@FXML
	private TableColumn<Usuario, String> columnEstado;
	@FXML
	private TableView<Usuario> tabelaUsuario;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtCpf;
	@FXML
	private TextField txtTelefone;
	@FXML
	private TextField txtEndereco;
	@FXML
	private TextField txtNumero;
	@FXML
	private TextField txtCidade;
	@FXML
	private ComboBox<Estado> cbEstado;

	@FXML
	public void adicionarUsuario()
	{
		if (this.txtNome.getText().isEmpty() || this.txtCpf.getText().isEmpty() || this.txtEndereco.getText().isEmpty()
				|| this.txtCidade.getText().isEmpty() || this.txtNumero.getText().isEmpty()
				|| this.txtTelefone.getText().isEmpty() || this.cbEstado.getValue().getEstado().isEmpty())
		{
			Alert alerta = new Alert(AlertType.INFORMATION, "Campos Não preenchidos!", ButtonType.CLOSE);
			alerta.show();
		} else
		{
			usuario = new Usuario(this.txtNome.getText(), this.txtCpf.getText(), this.txtTelefone.getText(),
					this.txtEndereco.getText(), this.txtNumero.getText(), this.txtCidade.getText(),
					this.cbEstado.getValue());
			this.listaUsuarios.add(usuario);
			loadTabelaUsuario();
			limparCampos();
		}
	}

	@FXML
	public void selecionar()
	{
		if (this.tabelaUsuario.getSelectionModel().getSelectedItem() != null)
		{
			this.usuario = this.tabelaUsuario.getSelectionModel().getSelectedItem();
			this.txtCidade.setText(this.usuario.getCidade());
			this.txtCpf.setText(this.usuario.getCpf());
			this.txtEndereco.setText(this.usuario.getEndereco());
			this.txtNome.setText(this.usuario.getNome());
			this.txtNumero.setText(this.usuario.getNumero());
			this.txtTelefone.setText(this.usuario.getTelefone());
			this.cbEstado.setValue(this.usuario.getEstado());
		}
	}

	@FXML
	public void update()
	{
		if (this.tabelaUsuario.getSelectionModel().getSelectedItem() != null)
		{
			this.usuario.setCidade(this.txtCidade.getText());
			this.usuario.setCpf(this.txtCpf.getText());
			this.usuario.setEndereco(this.txtEndereco.getText());
			this.usuario.setEstado(this.cbEstado.getValue());
			this.usuario.setNome(this.txtNome.getText());
			this.usuario.setNumero(this.txtNumero.getText());
			this.usuario.setTelefone(this.txtTelefone.getText());
			
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		loadComboEstado();

	}

	private Usuario usuario;
	private HashSet<Usuario> listaUsuarios = new HashSet<Usuario>();
	private ObservableList<Estado> listaEstados = FXCollections.observableArrayList(Estado.values());
	private ObservableList<Usuario> listaUsuarioTabela;

	public void loadTabelaUsuario()
	{
		this.columnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		this.columnCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		this.columnTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
		this.columnEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		this.columnNumero.setCellValueFactory(new PropertyValueFactory<>("numero"));
		this.columnCidade.setCellValueFactory(new PropertyValueFactory<>("cidade"));
		this.columnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
		this.listaUsuarioTabela = FXCollections.observableArrayList(this.listaUsuarios);
		this.tabelaUsuario.setItems(this.listaUsuarioTabela);
	}

	private void loadComboEstado()
	{
		this.cbEstado.setItems(listaEstados);
	}

	public void limparCampos()
	{
		this.txtCidade.setText("");
		this.txtCpf.setText("");
		this.txtEndereco.setText("");
		this.txtNome.setText("");
		this.txtNumero.setText("");
		this.txtTelefone.setText("");
		this.cbEstado.setValue(null);
	}
}
