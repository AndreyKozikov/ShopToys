package Presenter;

import Model.FileIO;
import Model.Interfaces.InputDataHandler;
import Model.Interfaces.MenuPrinter;
import Model.Interfaces.MessageHandler;
import Model.Interfaces.Operations;
import Model.Menu.Menu;
import Model.Operations.ShopOperations;
import View.ToysShopView;

import java.util.ArrayList;

public class ToysShopPresenter {

    private ShopOperations operationsMenu;
    private ToysShopView view;

    public ToysShopPresenter() {
        this.view = new ToysShopView();
        this.operationsMenu = new ShopOperations();
    }

    private String menu(String path, ShopOperations operationsMenu) {
        String result = "";
        ArrayList<Menu> menu;
        menu = FileIO.readMenuFromFile(path);
        for (Menu item : menu) {
            operationsMenu.addOperation(item.getId(), item.getOperation());
            result += item.getName() + "\n";
        }
        return result;
    }

    public void run() {
        boolean exit = false;
        showMessage("Добро пожаловать в программу проведения розыгрышей магазина Игрушки.");
        while (!exit) { //Для завершения программы предусмотрена команда ВЫХОД
            showMessage("Выберите действие, введя соответствующую цифру пункта меню.");
            showMessage(menu("shopmenu.txt", this.operationsMenu));
            int input = Integer.parseInt(inputData("Что будем делать? Выбирайте: "));
            Operations doOperation = operationsMenu.getOperation(input);
            MessageHandler out = this::showMessage;
            InputDataHandler in = this::inputData;
            MenuPrinter menu = this::menu;
            try {
                exit = doOperation.performOperation(out, in, menu);
            } catch (NullPointerException e) {
                showMessage("Данная операция не поддерживается. Повторите ввод.");
            }
        }
    }

    private void showMessage(String prompt) {
        view.showMessage(prompt);
    }

    private String inputData(String prompt) {
        return view.inputData(prompt);
    }
}
