package br.jus.tjms.sgpd.tests.calculo;

import br.jus.tjms.sgpd.engine.calculo.FolhaCalculo;
import br.jus.tjms.sgpd.engine.calculo.FolhaCalculoFactory;
import br.jus.tjms.sgpd.engine.calculo.RubricaCalculoFactory;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculo;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculoApplier;
import br.jus.tjms.sgpd.engine.calculo.impl.FolhaNormalCalculoProcessor;
import br.jus.tjms.sgpd.engine.to.Contexto;
import br.jus.tjms.sgpd.entity.*;
import br.jus.tjms.sgpd.enumerators.*;
import br.jus.tjms.sgpd.formulas.FormulaAtraso;
import br.jus.tjms.sgpd.service.adicionalqualificacaoservices.ConcessaoAdicionalQualificacaoService;
import br.jus.tjms.sgpd.service.auxilioeducacaoservices.ConcessaoAuxilioEducacaoService;
import br.jus.tjms.sgpd.service.consignacaoservices.EmprestimoConsignadoService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AdicionalInsalubridadeService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AdicionalTempoIntegralService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.AuxilioTransporteService;
import br.jus.tjms.sgpd.service.evolucaofuncionalservices.GratificacaoEncargosEspeciaisService;
import br.jus.tjms.sgpd.service.feriasservices.ConcessaoFeriasService;
import br.jus.tjms.sgpd.service.folhapagamentoservices.PagamentoService;
import br.jus.tjms.sgpd.service.licencaservices.LicencaService;
import br.jus.tjms.sgpd.service.planosaudeservices.ContratoPlanoSaudeService;
import br.jus.tjms.sgpd.service.remuneracaoservices.LancamentoAvulsoService;
import br.jus.tjms.sgpd.util.DateUtilz;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class FormulasTest {

    private LicencaService licencaService;
    private ConcessaoFeriasService concessaoFeriasService;
    private ConcessaoAdicionalQualificacaoService concessaoAdicionalQualificacaoService;
    private ConcessaoAuxilioEducacaoService concessaoAuxilioEducacaoService;
    private ContratoPlanoSaudeService contratoPlanoSaudeService;
    private EmprestimoConsignadoService emprestimoConsignadoService;
    private PagamentoService pagamentoService;
    private LancamentoAvulsoService lancamentoAvulsoService;
    private AdicionalTempoIntegralService adicionalTempoIntegralService;
    private AuxilioTransporteService auxilioTransporteService;
    private GratificacaoEncargosEspeciaisService gratificacaoEncargosEspeciaisService;
    private AdicionalInsalubridadeService adicionalInsalubridadeService;

    private FolhaCalculo folhaNormalCalculo;
    private FolhaNormalCalculoProcessor folhaNormalCalculoProcessor;
    private FolhaNormalCalculoApplier folhaNormalCalculoApplier;

    private CalculoFolhaTestHelper calculoFolhaTestHelper = new CalculoFolhaTestHelper();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        licencaService = new LicencaService();
        concessaoFeriasService = new ConcessaoFeriasService();
        concessaoAdicionalQualificacaoService = new ConcessaoAdicionalQualificacaoService();
        concessaoAuxilioEducacaoService = new ConcessaoAuxilioEducacaoService();
        contratoPlanoSaudeService = new ContratoPlanoSaudeService();
        emprestimoConsignadoService = new EmprestimoConsignadoService();
        pagamentoService = new PagamentoService();
        lancamentoAvulsoService = new LancamentoAvulsoService();
        adicionalTempoIntegralService = new AdicionalTempoIntegralService();
        auxilioTransporteService = new AuxilioTransporteService();
        gratificacaoEncargosEspeciaisService = new GratificacaoEncargosEspeciaisService();
        adicionalInsalubridadeService = new AdicionalInsalubridadeService();

        folhaNormalCalculo = FolhaCalculoFactory.fabricar(TipoFolhaPagamento.NORMAL);
        folhaNormalCalculoApplier = FolhaNormalCalculoApplier.newInstance();
        folhaNormalCalculoProcessor = FolhaNormalCalculoProcessor.newInstance();
        folhaNormalCalculoApplier.setEmprestimoConsignadoService(emprestimoConsignadoService);
        folhaNormalCalculoApplier.setPagamentoService(pagamentoService);
        folhaNormalCalculoApplier.setLancamentoAvulsoService(lancamentoAvulsoService);


        ((FolhaNormalCalculo)folhaNormalCalculo)
                .setFolhaCalculoProcessor(folhaNormalCalculoProcessor)
                .setFolhaCalculoApplier(folhaNormalCalculoApplier)
                .setLicencaService(licencaService)
                .setConcessaoFeriasService(concessaoFeriasService)
                .setConcessaoAdicionalQualificacaoService(concessaoAdicionalQualificacaoService)
                .setConcessaoAuxilioEducacaoService(concessaoAuxilioEducacaoService)
                .setContratoPlanoSaudeService(contratoPlanoSaudeService)
                .setEmprestimoConsignadoService(emprestimoConsignadoService)
                .setAdicionalTempoIntegralService(adicionalTempoIntegralService)
                .setAuxilioTransporteService(auxilioTransporteService)
                .setGratificacaoEncargosEspeciaisService(gratificacaoEncargosEspeciaisService)
                .setAdicionalInsalubridadeService(adicionalInsalubridadeService);
    }


	private Rubrica criarRubricaBasica(String expressao, TipoFormula tipoFormula) {
        Rubrica rubrica = new Rubrica();

        Formula formula =  new Formula();
        formula.setExpressao(expressao);
        formula.setTipo(tipoFormula);
        formula.setGlobal(true);

        RubricaFormula rubricaFormula =  new RubricaFormula(rubrica, formula);
        rubrica.setFormulas(Collections.singletonList(rubricaFormula));
        return rubrica;
    }

    @Test
    public void testaFormulaAtrasoSemHoras() {
        Contexto contexto = new Contexto();
        Rubrica rubrica = criarRubricaBasica(FormulaAtraso.class.getName(), TipoFormula.CLASSE);

        Double resultado = RubricaCalculoFactory.fabricar(TipoRubrica.FORMULA).calcular(contexto, rubrica).getResultado();

        assertTrue(resultado == 0);
    }

    @Test
    public void testaFormulaAtraso() {
        //1907	1	ATRASO/SAÍDA ANTECIPADA
        FolhaPagamento folha = calculoFolhaTestHelper.montaFolhaParaTesteCalcularFolhaNormalBasica2018();
        Contexto contexto = calculoFolhaTestHelper.montaContextoParaTesteCalcularFolhaNormal(folha);

        Rubrica rubrica = criarRubricaBasica(FormulaAtraso.class.getName(), TipoFormula.CLASSE);
        rubrica.setSequenciaCalculo(Integer.MAX_VALUE);
        rubrica.setSinal(Sinal.NEGATIVO);
        rubrica.setTipo(TipoRubrica.FORMULA);

        FormulaInput formulaInput = new FormulaInput();
        formulaInput.setNome("horasAtraso");
        formulaInput.setValor(1.0);
        rubrica.getFormulas().get(0).getFormula().getInputs().add(formulaInput);
        //contexto.getFormulaInputs().add(formulaInput);
        //contexto.input("horasAtraso").setValor(1.0);

        FormulaInput formulaInput2 = new FormulaInput();
        formulaInput2.setNome("cargaHoraria");
        rubrica.getFormulas().get(0).getFormula().getInputs().add(formulaInput2);
        formulaInput2.setValor(150);
       // contexto.getFormulaInputs().add(formulaInput2);
        //contexto.input("cargaHoraria").setValor(150);

        FormulaOutput formulaOutput = new FormulaOutput();
        formulaOutput.setNome("atrasos");
        rubrica.getFormulas().get(0).getFormula().getOutputs().add(formulaOutput);
        //contexto.getFormulaOutputs().add(formulaOutput);

        Cargo cargo = folha.getFuncionarios().get(0).getFuncionario().getCargos().get(0).getCargo();

//      rubrica.setUtilizaTiposBaseCalculo(Arrays.asList(new RubricaUtilizaBaseCalculo(2l, rubrica, TipoBaseCalculo.PREVIDENCIA_PROPRIA)));
//      rubrica.getCompoeTiposBaseCalculo().add(new RubricaCompoeBaseCalculo(rubrica, TipoBaseCalculo.IMPOSTO_RENDA));
        rubrica.setRubricasBase(criarRubricasBase(cargo.getRubricasBase(), rubrica));

        cargo.getRubricas().add(new RubricaCargo(Long.MAX_VALUE, rubrica, cargo, TipoFolhaPagamento.NORMAL));


        folhaNormalCalculo = FolhaCalculoFactory.fabricar(TipoFolhaPagamento.NORMAL);
        folhaNormalCalculo.calcular(contexto, folha);

        Double total = folha.getTotalLiquido();
        Double resultadoEsperadoTotal = 5093.78;

        assertTrue(total < resultadoEsperadoTotal);
    }


    public List<RubricaBase> criarRubricasBase(List<Rubrica> rubricasCargo, Rubrica rubrica) {
        List<RubricaBase> rubricasBase = new ArrayList<>();
        for (Rubrica rubricaCargo: rubricasCargo) {
            RubricaBase rubricaBase =  new RubricaBase(rubrica, rubricaCargo);
            rubricasBase.add(rubricaBase);
        }

        return rubricasBase;
    }


}