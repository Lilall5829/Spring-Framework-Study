package com.example.assign2.TransposeMatrix;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class MatrixController {
    public MatrixTransposeService matrixTransposeService;

    public MatrixController(MatrixTransposeService matrixTransposeService) {
        this.matrixTransposeService = matrixTransposeService;
    }

    @RequestMapping(value = "transpose", method = RequestMethod.GET)
    public String tranpose() {
        return "transposedMatrix";
    }

    @RequestMapping(value = "transpose", method = RequestMethod.POST)
    public String output(@RequestParam String matrix00, String matrix01, String matrix10, String matrix11, ModelMap model) {
        int[][] matrix = matrixTransposeService.toMatrix(matrix00,matrix01,matrix10,matrix11);
        matrix = matrixTransposeService.transposeMatrix(matrix);
        model.put("matrix00", matrix[0][0]);
        model.put("matrix01", matrix[0][1]);
        model.put("matrix10", matrix[1][0]);
        model.put("matrix11", matrix[1][1]);
        return "transposedMatrix";

    }
}