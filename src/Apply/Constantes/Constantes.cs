using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace TesteEstágioBackendV2.src.Apply.Constantes
{
    public static class Constantes
    {
        //msgs
		public const string RegistoEliminado = "Registo eliminado com sucesso!";
		public const string RegistoSalvo = "Registo salvo com sucesso!";
		public const string RegistoActualizado = "Registo actualizado com sucesso!";

		//Msg Error when create user account
		public const string MsgErroCaracterDeSenhaMaisculo = "Estrutura de senha inválida, a senha requer por apenas um carácter em maiúsculo [A-Z]";
		public const string MsgErroCaracterDeSenhaNumerico = "Estrutura de senha inválida, a senha requer por apenas um carácter numérico [0-9]";
		public const string MsgErroCaracterDeSenhaEspecial = "Estrutura de senha inválida, a senha requer por apenas um carácter especial [#,*,/]";


		//File formats
		public const string ExcellWorkbook = ".xlsx";
		public const string Excel97Excel2003Workbook = ".xls";
		public const string PdfFile = ".pdf";
		public const string PdfFile2 = ".PDF";


		//Mime Types
		public const string WordDocs = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
		public const string excelDocs = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		public const string pdfsDocus = "application/pdf";

		//files coringas
		public const string ImageFile = "image";

		//users
		public const string MailServer1 = "srv-tl-ex01";
		public const string MailServer2 = @"webmail.ucall.co.ao";
		public const string MailServer3 = @"smtp.office365.com";
		public const string User1 = "wfernando";
		public const string SenhaUser1 = "kavetuhande2023";
		public const string User6 = "contact-center@bicseguros.ao";
		public const string SenhaUser6 = "Jus10983";
		public const string MailUser6 = "contact-center@bicseguros.ao";
		public const string MailUser2 = "servicetools.teste@ucall.co.ao";
		public const string User2 = @"servicetools.teste";
		public const string SenhaUser2 = @"$It@2o5G$k.*";
		public const string MailUser3 = "tickets.logistica@ucall.co.ao";
		public const string User3 = @"tickets.logistica";
		public const string SenhaUser3 = @"tickets.logistica";
		public const string MailUser4 = "suporte.logistica@ucall.co.ao";
		public const string User4 = @"suporte.logistica";
		public const string SenhaUser4 = @"suporte.logisticazx";

		public const string MailUser5 = "wilson.fernando@ucall.co.ao";


		public const string OwinChallengeFlag = "X-Challenge";

		//Informations msgs
		public const string SenhasDiferentes = "As senhas não coincidem, tente Novamente!";
		public const string SucessMsg = "Sucess!";
		public const string ErrorMsg = "Errro!";

		//error msgs
		public const string LogErrorMessage = "Erro ao executar a operação : ";
		public const string ErroRecepcaoEmail = "Erro ao receber email ";


		//urls
		//public const string FullPathFilesPublicacoes = @"C:\xampp1\htdocs\SERVER-NODE\UTOOLS-96\Utools-BIC-main\src\statics";//68
		//public const string FullPathFilesPublicacoes = @"D:\WebHost\Intranet\main\statics";//236
		//public const string FullPathFilesPublicacoes = @"D:\WebHost\UtoolsBic\main\statics";//237
		//public const string MidlelPathFilesPublicacoes = @"statics";
		//public const string PathFolderPublicacoes = @"FilesPublicacoes";

		public const string FullPathFilesPublicacoes = @"C:\WebHost\Digital_Office\main";//68

		public const string FullPathFilesPublicacoes1 = @"E:\WebHost\Digital_Office\main";//236

		//public const string MidlelPathFilesPublicacoes = @"assets";
		public const string PathFolderPublicacoes = @"FilesPubs";

		//public const string FullPathFilesFotosFuncionarios = @"C:\xampp1\htdocs\SERVER-NODE\INTRANET\Cli-main\u-intranet-layout-main\src\statics";
		//public const string MidlelPathFilesFotosFuncionairo = @"statics";

		public const string PathFilesPublicacoesTest = @"C:\xampp1\htdocs";
		public const string PathFilesPublicacoesTestForder = @"htdocs";


		public const string PathFolderFotosFuncionarios = @"FilesTickets";

		public const string PathFileChamadas = "/Files/chamadas/";
		public const string PathFileDocumentos = "/Files/documentos/";
		public const string PathFileExcellCandidaturas = "/Files/tempFilesCandidatura/";
		public const string PathFileExcellInqueritos = "/Files/tempFilesInquerito/";
		public const string PathFileInteracoes = "/Files/interacoes/";
		public const string PathFileInteracoesTemporaria = "/Files/interacoes/pastaTemporaria";
		public const string PathFileFotosUtilizadores = "/Files/fotosUtilizadores/";
		public const string PathFileVideos = "/Files/Videos/";
		public const string PathTemporaria = "/Files/temp/";

		public const string PathTemporariaTicketsDetails = "/Files/tempTicketsDetails/";
		public const string PathFileFotosUtilizadoresTemporaria = "/Files/fotosUtilizadoresTemporaria/";

		//server *68 Teste
		//public static string APP_PATH = @"C:\xampp1\htdocs\SERVER-NODE\UTOOLS-96\TicketsLogistica\Front-main\src\statics";

		//server *237 Homologação
		//public static string APP_PATH = @"D:\WebHost\UtoolsBic\main\statics";

		//server *236 Produção
		public static string APP_PATH = @"D:\WebHost\_UtoolsBancoBIC\main\statics";


		public static string PathProgramSox = @"C:\Program Files (x86)\sox-14-4-2\sox.exe";
		public const string UrlInqueritoLogistica = "http://ticketslogistica.ucall.co.ao:8292/Logistica/QuestaoInquerito/Questionario?NumeroPedido=";


		//error dcodes
		public const int StatusCodeError = 1;
		public const int StatusCodeSucess = 0;

		//sqls strings
		public const string ListarColaboradoresElo = @"SELECT *FROM [Dcs2nGProd_ELO].[dbo].[vDadosColaborador_Intranet]";
    }
}