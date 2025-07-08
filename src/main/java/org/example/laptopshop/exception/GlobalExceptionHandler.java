package org.example.laptopshop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ModelAndView handleProductNotFound(ProductNotFoundException ex) {
        ModelAndView mav = new ModelAndView("admin/product/404-error");
        mav.addObject("message", ex.getMessage());
        return mav;
    }
}
