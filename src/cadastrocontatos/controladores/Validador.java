package cadastrocontatos.controladores;

import cadastrocontatos.excecoes.CnpjInvalidoException;
import cadastrocontatos.excecoes.CpfInvalidoException;

/**
 *
 * @author luluf
 */
public class Validador {
    
    
    public static void isCpf(String cpf) throws CpfInvalidoException {
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ||
           (cpf.length() != 14))
           throw new CpfInvalidoException();
        
        boolean cpfValido = false;
        String base = "000000000";
        String digitos = "00";
        if (cpf.length() <= 11) {
            if (cpf.length() < 11) {
                cpf = base.substring(0, 11 - cpf.length()) + cpf;
                base = cpf.substring(0, 9);
            }
            base = cpf.substring(0, 9);
            digitos = cpf.substring(9, 11);
            int soma = 0, mult = 11;
            int[] var = new int[11];
        
            // Recebe os números e realiza a multiplicação e soma.
            for (int i = 0; i < 9; i++) {
                var[i] = Integer.parseInt("" + cpf.charAt(i));
                if (i < 9)
                    soma += (var[i] * --mult);
            }
            // Cria o primeiro dígito verificador.
            int resto = soma % 11;
            if (resto < 2) {
            var[9] = 0;
            }
            else {
                var[9] = 11 - resto;
            }
        
            soma = 0;
            mult = 11;

            // Realiza a multiplicação e soma do segundo dígito.
            for (int i = 0; i < 10; i++)
            soma += var[i] * mult--;
            // Cria o segundo dígito verificador.
            resto = soma % 11;
            if (resto < 2) {
                var[10] = 0;
            } else {
                var[10] = 11 - resto;
            }


            if ((digitos.substring(0, 1).equalsIgnoreCase(new Integer(var[9]).toString())) &&
                (digitos.substring(1, 2).equalsIgnoreCase(new Integer( var[10]).toString()))) {
                    cpfValido = true;
            }
        }
        if (!cpfValido) {
            throw new CpfInvalidoException();
        }
    }
    
    
    public static void isCnpj(String CNPJ) throws CnpjInvalidoException {
        
            if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") ||
            CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") ||
            CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") ||
            CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") ||
            CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") ||
           (CNPJ.length() != 14))
           throw new CnpjInvalidoException();

        char dig13, dig14;
        int sm, i, r, num, peso;

        sm = 0;
        peso = 2;

        for (i=11; i>=0; i--) {
          num = (int)(CNPJ.charAt(i) - 48);
          sm = sm + (num * peso);
          peso = peso + 1;
          if (peso == 10)
             peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
          dig13 = '0';
        else 
          dig13 = (char)((11-r) + 48);

        sm = 0;
        peso = 2;
        for (i=12; i>=0; i--) {
          num = (int)(CNPJ.charAt(i)- 48);
          sm = sm + (num * peso);
          peso = peso + 1;
          if (peso == 10)
             peso = 2;
        }

        r = sm % 11;
        if ((r == 0) || (r == 1))
           dig14 = '0';
        else
          dig14 = (char)((11-r) + 48);

        if ((dig13 != CNPJ.charAt(12)) || (dig14 != CNPJ.charAt(13))){
            throw new CnpjInvalidoException();
        }
    }
}
