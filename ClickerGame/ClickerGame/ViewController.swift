import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var scoreLabel: UILabel!
    @IBOutlet weak var mineButton: UIButton!
    @IBOutlet weak var resetButton: UIButton!
    @IBOutlet weak var upgradeButton: UIButton!
    @IBOutlet weak var upgradeCostLabel: UILabel!
    @IBOutlet weak var backgroundImageView: UIImageView!

    var score = 0
    var multiplier = 1
    var upgradeCost = 10
//background image
    override func viewDidLoad() {
        super.viewDidLoad()
        updateUpgradeCostLabel()
        backgroundImageView.image = UIImage(named: "starminer1")
    }
//mining functionality
    @IBAction func mineButtonTapped(_ sender: UIButton) {
        print("Mine button tapped")
        score += multiplier
        scoreLabel.text = "Rocks Mined: \(score)"
        backgroundImageView.image = UIImage(named: "starminer2")

        DispatchQueue.main.asyncAfter(deadline: .now() + 0.5) {
            self.backgroundImageView.image = UIImage(named: "starminer1")
        }
    }
//Reset button functionality
    @IBAction func resetButtonTapped(_ sender: UIButton) {
        print("Reset button tapped")
        score = 0
        scoreLabel.text = "Rocks Mined: \(score)"
    }
//upgrade button and price functionality
    @IBAction func upgradeButtonTapped(_ sender: UIButton) {
        print("Upgrade button tapped")
        if score >= upgradeCost {
            score -= upgradeCost
            multiplier += 1
            upgradeCost *= 2
            scoreLabel.text = "Rocks Mined: \(score)"
            updateUpgradeCostLabel()
        }
    }

    func updateUpgradeCostLabel() {
        upgradeCostLabel.text = "Next Upgrade: \(upgradeCost)"
    }
}
